package com.nwar.uuid.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.nwar.uuid.R
import com.nwar.uuid.databinding.FragmentSurveyQuestionBinding
import com.nwar.uuid.ui.base.BaseFragment
import com.nwar.uuid.viewModel.viewModel.SurveyQuestionViewModel
import javax.inject.Inject

class SurveyQuestionFragment() : BaseFragment<FragmentSurveyQuestionBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_survey_question
    @Inject
    override lateinit var viewModel : SurveyQuestionViewModel


    override fun setViewModel() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.index.observe(this, Observer { viewModel.changeQuestion(it) })
    }
}