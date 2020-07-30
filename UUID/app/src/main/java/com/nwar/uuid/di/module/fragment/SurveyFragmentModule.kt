package com.nwar.uuid.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.domain.repository.SurveyRepository
import com.nwar.domain.usecase.GetSaleInfoListUseCase
import com.nwar.domain.usecase.SelectStoreInfoUseCase
import com.nwar.uuid.ui.fragment.SurveyFragment
import com.nwar.uuid.viewModel.factory.SurveyVMF
import com.nwar.uuid.viewModel.viewModel.SurveyViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
class SurveyFragmentModule() {
    @Provides
    fun viewModel(fragment : SurveyFragment, factory : SurveyVMF) = ViewModelProviders.of(fragment, factory)[SurveyViewModel::class.java]

    @Provides
    fun factory(loadStoreInfoListUseCase : GetSaleInfoListUseCase, selectStoreInfoUseCase: SelectStoreInfoUseCase) = SurveyVMF(loadStoreInfoListUseCase,selectStoreInfoUseCase)

    @Provides
    fun loadStoreInfoListUseCase(mainScheduler: Scheduler, surveyRepository: SurveyRepository) = GetSaleInfoListUseCase(mainScheduler,surveyRepository)

    @Provides
    fun selectSaleInfoUseCase(mainScheduler: Scheduler, surveyRepository: SurveyRepository) = SelectStoreInfoUseCase(mainScheduler,surveyRepository)
}