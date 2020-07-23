package com.nwar.uuid.viewModel.viewModel

import androidx.lifecycle.Lifecycle
import com.nwar.uuid.R
import com.nwar.uuid.ui.base.BaseViewModel

class SurveyViewModel() : BaseViewModel() {
    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_PAUSE -> onPause()
        }
    }

    override fun onPause() {
        nextFragment.postValue(null)
    }

    fun requireServey(position : Int) {
        nextFragment.postValue(R.id.action_mainFragment_to_surveyQuestionFragment)
    }
}