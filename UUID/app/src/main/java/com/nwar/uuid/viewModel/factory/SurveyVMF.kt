package com.nwar.uuid.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nwar.domain.usecase.GetSaleInfoListUseCase
import com.nwar.domain.usecase.SelectStoreInfoUseCase

class SurveyVMF(
    val loadStoreInfoListUseCase: GetSaleInfoListUseCase,
    val selectStoreInfoUseCase: SelectStoreInfoUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = modelClass.getConstructor(
        loadStoreInfoListUseCase::class.java,
        selectStoreInfoUseCase::class.java
    ).newInstance(loadStoreInfoListUseCase, selectStoreInfoUseCase)
}