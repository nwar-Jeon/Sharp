package com.nwar.uuid.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.domain.repository.AccountRepository
import com.nwar.domain.usecase.SignInUseCase
import com.nwar.uuid.ui.fragment.SignInFragment
import com.nwar.uuid.viewModel.factory.SignInVMF
import com.nwar.uuid.viewModel.viewModel.SignInViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
class SignInFragmentModule() {
    @Provides
    fun viewModel(fragment : SignInFragment, factory : SignInVMF) = ViewModelProviders.of(fragment, factory)[SignInViewModel::class.java]

    @Provides
    fun factory(signInUseCase: SignInUseCase) = SignInVMF(signInUseCase)

    @Provides
    fun signInUseCase(mainScheduler: Scheduler, accountRepository: AccountRepository) = SignInUseCase(mainScheduler,accountRepository)
}