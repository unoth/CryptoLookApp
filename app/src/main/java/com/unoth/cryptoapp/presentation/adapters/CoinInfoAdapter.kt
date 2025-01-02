package com.unoth.cryptoapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.unoth.cryptoapp.R
import com.unoth.cryptoapp.databinding.ItemCoinInfoBinding
import com.unoth.cryptoapp.domain.CoinInfo

class CoinInfoAdapter(private val context: Context) :
    RecyclerView.Adapter<CoinInfoViewHolder>() {

    var onCoinClickListener: OnCoinClickListener? = null
    var coinInfoList: List<CoinInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val binding =
            ItemCoinInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinInfoViewHolder(binding)
    }

    override fun getItemCount(): Int = coinInfoList.size
    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList[position]
        with(holder.binding) {
            with(coin) {
                val symbolTemplate = context.resources.getString(R.string.symbol_template)
                val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
                val priceTemplate = context.resources.getString(R.string.price_template)
                tvSym.text = String.format(symbolTemplate, fromsymbol, tosymbol)
                tvPrice.text = String.format(priceTemplate, price)
                tvUpdate.text =
                    String.format(lastUpdateTemplate, lastupdate)
                Picasso.get().load(imageurl).into(ivLogoCoin)
                root.setOnClickListener {
                    onCoinClickListener?.onCoinClick(this)
                }
            }
        }
    }

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinInfo)
    }

}