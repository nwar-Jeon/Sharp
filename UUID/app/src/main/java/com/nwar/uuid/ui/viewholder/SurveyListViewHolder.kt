package com.nwar.uuid.ui.viewholder

import com.nwar.uuid.databinding.ItemSurveyListBinding
import com.nwar.uuid.ui.base.BaseViewHolder
import com.nwar.uuid.viewModel.viewModel.SurveyViewModel

class SurveyListViewHolder(val binding : ItemSurveyListBinding, val vm : SurveyViewModel) : BaseViewHolder(binding.root) {
    override fun bind() {
        binding.position = index
        binding.vm = vm
    }
}