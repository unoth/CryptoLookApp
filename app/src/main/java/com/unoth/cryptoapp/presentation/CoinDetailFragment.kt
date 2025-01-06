package com.unoth.cryptoapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.unoth.cryptoapp.R
import com.unoth.cryptoapp.databinding.FragmentCoinDetailBinding

class CoinDetailFragment : Fragment() {

    private lateinit var viewModel: CoinViewModel

    private var _binding: FragmentCoinDetailBinding? = null
    private val binding: FragmentCoinDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentCoinDetailBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fromSymbol = getSymbol()
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.getDetailInfo(fromSymbol).observe(viewLifecycleOwner, Observer {
            val priceTemplate = resources.getString(R.string.price_template)
            with(binding) {
                tvPrice.text = String.format(priceTemplate, it.price)
                tvMinPrice.text = String.format(priceTemplate, it.lowday)
                tvMaxPrice.text = String.format(priceTemplate, it.highday)
                tvLastMarket.text = it.lastmarket
                tvLastUpdate.text = it.lastupdate
                tvFromSymbol.text = it.fromsymbol
                tvToSymbol.text = it.tosymbol
                Picasso.get().load(it.imageurl).into(binding.ivLogoCoin)
            }
        })
    }

    private fun getSymbol(): String {
        return requireArguments().getString(EXTRA_FROM_SYM, EMPTY_SYM)
    }

    companion object {
        private const val EXTRA_FROM_SYM = "fSym"
        private const val EMPTY_SYM = ""

        fun newInstance(fromSymbol: String): Fragment {
            return CoinDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_FROM_SYM, fromSymbol)
                }
            }
        }
    }
}