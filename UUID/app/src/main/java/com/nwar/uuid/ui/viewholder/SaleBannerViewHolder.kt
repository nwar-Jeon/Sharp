package com.nwar.uuid.ui.viewholder

import com.nwar.uuid.databinding.ItemBannerSaleBinding
import com.nwar.uuid.ui.base.BaseViewHolder
import com.nwar.uuid.viewModel.viewModel.HomeViewModel

class SaleBannerViewHolder(val binding: ItemBannerSaleBinding, val vm : HomeViewModel) : BaseViewHolder(binding.root) {
    override fun bind() {
        binding.vm = vm
        binding.position = index
    }
}