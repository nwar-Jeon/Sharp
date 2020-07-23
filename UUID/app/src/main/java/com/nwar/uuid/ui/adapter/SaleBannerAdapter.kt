package com.nwar.uuid.ui.adapter

import android.content.Context
import com.nwar.uuid.R
import com.nwar.uuid.databinding.ItemBannerSaleBinding
import com.nwar.uuid.ui.base.BaseAdapter
import com.nwar.uuid.ui.base.BaseViewHolder
import com.nwar.uuid.ui.viewholder.SaleBannerViewHolder

class SaleBannerAdapter(context : Context) : BaseAdapter<ItemBannerSaleBinding>(context) {

    override val layoutId : Int = R.layout.item_banner_sale

    override fun getItemCount() = 10

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
    }

    override fun createViewHolder(binding: ItemBannerSaleBinding, viewType: Int): BaseViewHolder = SaleBannerViewHolder(binding)

}