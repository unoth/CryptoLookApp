package com.unoth.cryptoapp.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.unoth.cryptoapp.R
import com.unoth.cryptoapp.databinding.ActivityCoinDetailBinding

class CoinDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    private val binding by lazy {
        ActivityCoinDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        val fromSymbol = intent.getStringExtra(EXTRA_FROM_SYM)
        if (fromSymbol != null) {
            viewModel.getDetailInfo(fromSymbol).observe(this, Observer {
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
    }

    companion object {
        private const val EXTRA_FROM_SYM = "fSym"

        fun newIntent(context: Context, fromSymbol: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYM, fromSymbol)
            return intent
        }
    }
}