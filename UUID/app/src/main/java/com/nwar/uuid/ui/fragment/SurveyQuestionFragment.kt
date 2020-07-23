package com.nwar.uuid.ui.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.uuid.R
import com.nwar.uuid.databinding.FragmentSurveyQuestionBinding
import com.nwar.uuid.ui.base.BaseFragment
import com.nwar.uuid.viewModel.viewModel.SurveyQuestionViewModel

class SurveyQuestionFragment() : BaseFragment<FragmentSurveyQuestionBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_survey_question
    override val viewModel by lazy { ViewModelProviders.of(this)[SurveyQuestionViewModel::class.java] }

    override fun setViewModel() {
        binding.vm = viewModel
    }
}