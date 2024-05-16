package com.unoth.cryptoapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.unoth.cryptoapp.R
import com.unoth.cryptoapp.databinding.ItemCoinInfoBinding
import com.unoth.cryptoapp.pojo.CoinPriceInfo

class CoinInfoAdapter(private val context: Context) :
    RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {

    var onCoinClickListener: OnCoinClickListener? = null
    var coinInfoList: List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class CoinInfoViewHolder(binding: ItemCoinInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val ivLogoCoin = binding.ivLogoCoin
        val tvSym = binding.tvSym
        val tvPrice = binding.tvPrice
        val tvUpdate = binding.tvUpdate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view = ItemCoinInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinInfoViewHolder(view)
    }

    override fun getItemCount(): Int = coinInfoList.size
    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList[position]
        with(holder) {
            with(coin) {
                val symbolTemplate = context.resources.getString(R.string.symbol_template)
                val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
                val priceTemplate = context.resources.getString(R.string.price_template)
                tvSym.text = String.format(symbolTemplate, fromsymbol, tosymbol)
                tvPrice.text = String.format(priceTemplate, price)
                tvUpdate.text = String.format(lastUpdateTemplate, getFormattedTime())
                Picasso.get().load(getFullImgUrl()).into(ivLogoCoin)
                itemView.setOnClickListener {
                    onCoinClickListener?.onCoinClick(this)
                }
            }
        }
    }

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinPriceInfo)
    }

}