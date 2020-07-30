package com.nwar.uuid.viewModel.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.entity.StoreInfo
import com.nwar.domain.usecase.GetSaleInfoListUseCase
import com.nwar.domain.usecase.GetWeeklyPointUseCase
import com.nwar.domain.usecase.SelectStoreInfoUseCase
import com.nwar.uuid.R
import com.nwar.uuid.ui.base.BaseViewModel
import com.nwar.uuid.util.Subscriber

class HomeViewModel(val getSaleInfoListUseCase: GetSaleInfoListUseCase, val getWeeklyPointUseCase: GetWeeklyPointUseCase, val selectStoreInfoUseCase: SelectStoreInfoUseCase) : BaseViewModel() {

    val name = MutableLiveData<String>("전승민")

    val tempSurveyList : MutableList<ObservableField<StoreInfo>> = mutableListOf()
    val surveyList = MutableLiveData<List<ObservableField<StoreInfo>>>()

    val collectPointInWeek = MutableLiveData<Int>(0)

    val weeklyPointSubscriber get() = Subscriber<Int>({
        collectPointInWeek.postValue(it)
    },{},{
        toast.postValue(it?.message)
    })

    val storeListSubscriber get() = Subscriber<StoreInfo>({
        tempSurveyList.add(ObservableField(it))
    }, {
        surveyList.postValue(tempSurveyList)
    }, {
        toast.postValue(it?.message)
    })

    val saleInfoSaveToCacheSubscriber get() = Subscriber<Unit>({},{
        nextFragment.postValue(R.id.action_mainFragment_to_surveyQuestionFragment)
    },{
        toast.postValue(it?.message)
    })

    override fun onCreate() {
        super.onCreate()
        getWeeklyPointUseCase.execute(Unit, weeklyPointSubscriber)
        getSaleInfoListUseCase.execute(Unit, storeListSubscriber)
    }

    override fun onPause() {
        super.onPause()
        nextFragment.postValue(null)
    }

    fun requireSurvey(position : Int) {
        val storeInfo = surveyList.value?.get(position)?.get() ?: return
        selectStoreInfoUseCase.execute(storeInfo, saleInfoSaveToCacheSubscriber)
    }
}