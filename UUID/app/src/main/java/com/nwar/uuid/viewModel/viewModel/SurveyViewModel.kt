package com.nwar.uuid.viewModel.viewModel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.entity.StoreInfo
import com.nwar.domain.usecase.GetSaleInfoListUseCase
import com.nwar.domain.usecase.SelectStoreInfoUseCase
import com.nwar.uuid.R
import com.nwar.uuid.ui.base.BaseViewModel
import com.nwar.uuid.util.Subscriber

class SurveyViewModel(val loadStoreInfoListUseCase : GetSaleInfoListUseCase, val selectStoreInfoUseCase: SelectStoreInfoUseCase) : BaseViewModel() {

    var tempSurveyList : MutableList<ObservableField<StoreInfo>> = mutableListOf()
    val surveyList = MutableLiveData<List<ObservableField<StoreInfo>>>()

    val loadStoreInfoSubscriber get() = Subscriber<StoreInfo>({
        tempSurveyList.add(ObservableField(it))
    },{
        surveyList.postValue(tempSurveyList)
    },{
        toast.postValue(it?.message)
    })

    val selectSaleInfoSubscriber get() = Subscriber<Unit>({},{
        nextFragment.postValue(R.id.action_mainFragment_to_surveyQuestionFragment)
    },{
        toast.postValue(it?.message)
    })

    override fun onCreate() {
        super.onCreate()
        Log.e("onCreate", "onCreate")
        loadStoreInfoListUseCase.execute(Unit, loadStoreInfoSubscriber)
    }

    override fun onPause() {
        nextFragment.postValue(null)
    }

    fun requireSurvey(position : Int) {
        val storeInfo = surveyList.value?.get(position)?.get() ?: return
        selectStoreInfoUseCase.execute(storeInfo, selectSaleInfoSubscriber)
    }
}