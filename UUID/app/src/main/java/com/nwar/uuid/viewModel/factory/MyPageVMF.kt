package com.nwar.uuid.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nwar.domain.usecase.GetWeeklyPointUseCase

class MyPageVMF(val getWeeklyPointUseCase: GetWeeklyPointUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = modelClass.getConstructor(getWeeklyPointUseCase::class.java).newInstance(getWeeklyPointUseCase)
}