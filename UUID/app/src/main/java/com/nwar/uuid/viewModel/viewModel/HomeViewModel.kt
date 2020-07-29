package com.nwar.uuid.viewModel.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.dummyData.getSaleInfoList
import com.nwar.domain.entity.StoreInfo
import com.nwar.uuid.R
import com.nwar.uuid.ui.base.BaseViewModel

class HomeViewModel() : BaseViewModel() {

    val name = MutableLiveData<String>("전승민")

    val surveyList = MutableLiveData<List<ObservableField<StoreInfo>>>()

    val collectPointInWeek = MutableLiveData<Int>(10)

    override fun onCreate() {
        super.onCreate()
        surveyList.postValue(getSaleInfoList().map { ObservableField(it) })
    }

    override fun onPause() {
        super.onPause()
        nextFragment.postValue(null)
    }

    fun requireSurvey(position : Int) {
        nextFragment.postValue(R.id.action_mainFragment_to_surveyQuestionFragment)
    }
}