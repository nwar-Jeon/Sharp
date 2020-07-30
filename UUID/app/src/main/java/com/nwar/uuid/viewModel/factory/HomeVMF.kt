package com.nwar.uuid.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nwar.domain.usecase.GetSaleInfoListUseCase
import com.nwar.domain.usecase.GetWeeklyPointUseCase
import com.nwar.domain.usecase.SelectStoreInfoUseCase

class HomeVMF(
    val getSaleInfoListUseCase: GetSaleInfoListUseCase,
    val getWeeklyPointUseCase: GetWeeklyPointUseCase,
    val selectStoreInfoUseCase: SelectStoreInfoUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = modelClass.getConstructor(
        getSaleInfoListUseCase::class.java,
        getWeeklyPointUseCase::class.java,
        selectStoreInfoUseCase::class.java
    ).newInstance(getSaleInfoListUseCase, getWeeklyPointUseCase, selectStoreInfoUseCase)
}