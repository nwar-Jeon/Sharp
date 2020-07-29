package com.nwar.uuid.ui.adapter

import android.content.Context
import com.nwar.uuid.R
import com.nwar.uuid.databinding.ItemSurveyListBinding
import com.nwar.uuid.ui.base.BaseAdapter
import com.nwar.uuid.ui.base.BaseViewHolder
import com.nwar.uuid.ui.viewholder.SurveyListViewHolder
import com.nwar.uuid.viewModel.viewModel.SurveyViewModel

class SurveyListAdapter(context: Context, val vm : SurveyViewModel) : BaseAdapter<ItemSurveyListBinding>(context) {
    override val layoutId = R.layout.item_survey_list

    override fun createViewHolder(binding: ItemSurveyListBinding, viewType: Int) = SurveyListViewHolder(binding, vm)

    override fun getItemCount() = vm.surveyList.value?.size ?: 0
}