package com.nwar.uuid.viewModel.viewModel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.nwar.uuid.ui.base.BaseViewModel

class SurveyQuestionViewModel() : BaseViewModel() {

    val index = MutableLiveData<Int>()
    val count = MutableLiveData<Int>()

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_CREATE -> onCreate()
        }
    }

    fun requireNavigateUp() {
        navigateUp.postValue(true)
    }

    override fun onCreate() {
        index.postValue(0)
        count.postValue(0)
    }

    fun requireClickBefore() {

    }

    fun requireClickAfter() {

    }
}