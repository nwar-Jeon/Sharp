package com.nwar.uuid.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.domain.repository.AccountRepository
import com.nwar.domain.usecase.GetWeeklyPointUseCase
import com.nwar.uuid.ui.fragment.MyPageFragment
import com.nwar.uuid.viewModel.factory.MyPageVMF
import com.nwar.uuid.viewModel.viewModel.MyPageViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
class MyPageFragmentModule() {
    @Provides
    fun viewModel(fragment : MyPageFragment, factory : MyPageVMF) = ViewModelProviders.of(fragment, factory)[MyPageViewModel::class.java]

    @Provides
    fun factory(getWeeklyPointUseCase: GetWeeklyPointUseCase) = MyPageVMF(getWeeklyPointUseCase)

    @Provides
    fun getWeeklyPointUseCase(mainScheduler : Scheduler, accountRepository : AccountRepository) = GetWeeklyPointUseCase(mainScheduler, accountRepository)
}