package com.nwar.uuid.ui.adapter

import android.content.Context
import com.nwar.uuid.R
import com.nwar.uuid.databinding.ItemBannerSaleBinding
import com.nwar.uuid.ui.base.BaseAdapter
import com.nwar.uuid.ui.base.BaseViewHolder
import com.nwar.uuid.ui.viewholder.SaleBannerViewHolder
import com.nwar.uuid.viewModel.viewModel.HomeViewModel

class SaleBannerAdapter(context : Context, val vm : HomeViewModel) : BaseAdapter<ItemBannerSaleBinding>(context) {

    override val layoutId : Int = R.layout.item_banner_sale

    override fun getItemCount() = vm.surveyList.value?.size ?: 0

    override fun createViewHolder(binding: ItemBannerSaleBinding, viewType: Int): BaseViewHolder = SaleBannerViewHolder(binding, vm)

}