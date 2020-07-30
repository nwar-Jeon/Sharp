package com.nwar.uuid.viewModel.viewModel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.usecase.GetWeeklyPointUseCase
import com.nwar.uuid.ui.base.BaseViewModel
import com.nwar.uuid.util.Subscriber

class MyPageViewModel(val getWeeklyPointUseCase: GetWeeklyPointUseCase) : BaseViewModel() {

    val weeklyPoint = MutableLiveData(0)

    val weeklyPointSubscriber get() = Subscriber<Int>({
        weeklyPoint.postValue(it)
    },{},{
        toast.postValue(it?.message)
    })

    override fun onCreate() {
        super.onCreate()
        getWeeklyPointUseCase.execute(Unit, weeklyPointSubscriber)
    }
}