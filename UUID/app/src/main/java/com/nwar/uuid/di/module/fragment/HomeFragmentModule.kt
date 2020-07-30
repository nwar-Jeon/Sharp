package com.nwar.uuid.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.domain.repository.AccountRepository
import com.nwar.domain.repository.SurveyRepository
import com.nwar.domain.usecase.GetSaleInfoListUseCase
import com.nwar.domain.usecase.GetWeeklyPointUseCase
import com.nwar.domain.usecase.SelectStoreInfoUseCase
import com.nwar.uuid.ui.fragment.HomeFragment
import com.nwar.uuid.viewModel.factory.HomeVMF
import com.nwar.uuid.viewModel.viewModel.HomeViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
class HomeFragmentModule() {
    @Provides
    fun viewModel(fragment : HomeFragment, factory : HomeVMF) = ViewModelProviders.of(fragment, factory)[HomeViewModel::class.java]

    @Provides
    fun factory(getWeeklyPointUseCase: GetWeeklyPointUseCase, getStoreInfoListUseCase: GetSaleInfoListUseCase, selectStoreInfoUseCase: SelectStoreInfoUseCase) = HomeVMF(getStoreInfoListUseCase, getWeeklyPointUseCase, selectStoreInfoUseCase)

    @Provides
    fun getStoreInfoListUseCase(mainScheduler: Scheduler, surveyRepository: SurveyRepository) = GetSaleInfoListUseCase(mainScheduler, surveyRepository)

    @Provides
    fun weeklyPointUseCase(mainScheduler: Scheduler, accountRepository: AccountRepository) = GetWeeklyPointUseCase(mainScheduler,accountRepository)

    @Provides
    fun selectSaleInfoUseCase(mainScheduler: Scheduler, surveyRepository: SurveyRepository) = SelectStoreInfoUseCase(mainScheduler,surveyRepository)
}