package com.unoth.cryptoapp

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
import com.unoth.cryptoapp.databinding.ActivityCoinDetailBinding

class CoinDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: CoinViewModel
    private lateinit var binding: ActivityCoinDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinDetailBinding.inflate(layoutInflater)
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
                binding.tvPrice.text = String.format(priceTemplate, it.price)
                binding.tvMinPrice.text = String.format(priceTemplate, it.lowday)
                binding.tvMaxPrice.text = String.format(priceTemplate, it.highday)
                binding.tvLastMarket.text = it.lastmarket
                binding.tvLastUpdate.text = it.getFormattedTime()
                binding.tvFromSymbol.text = it.fromsymbol
                binding.tvToSymbol.text = it.tosymbol
                Picasso.get().load(it.getFullImgUrl()).into(binding.ivLogoCoin)
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