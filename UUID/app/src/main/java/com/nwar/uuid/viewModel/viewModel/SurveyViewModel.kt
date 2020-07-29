package com.nwar.uuid.viewModel.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.dummyData.getSaleInfoList
import com.nwar.domain.entity.StoreInfo
import com.nwar.uuid.R
import com.nwar.uuid.ui.base.BaseViewModel

class SurveyViewModel() : BaseViewModel() {

    val surveyList = MutableLiveData<List<ObservableField<StoreInfo>>>()

    override fun onCreate() {
        super.onCreate()
        surveyList.postValue(getSaleInfoList().map { ObservableField(it) })
    }

    override fun onPause() {
        nextFragment.postValue(null)
    }

    fun requireSurvey(position : Int) { nextFragment.postValue(R.id.action_mainFragment_to_surveyQuestionFragment) }
}