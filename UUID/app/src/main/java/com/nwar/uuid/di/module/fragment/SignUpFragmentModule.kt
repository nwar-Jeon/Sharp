package com.nwar.uuid.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.domain.repository.AccountRepository
import com.nwar.domain.usecase.SignUpUseCase
import com.nwar.uuid.ui.fragment.SignUpFragment
import com.nwar.uuid.viewModel.factory.SignUpVMF
import com.nwar.uuid.viewModel.viewModel.SignUpViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
class SignUpFragmentModule {
    @Provides
    fun viewModel(fragment : SignUpFragment, factory : SignUpVMF) = ViewModelProviders.of(fragment, factory)[SignUpViewModel::class.java]

    @Provides
    fun factory(signUpUseCase: SignUpUseCase) = SignUpVMF(signUpUseCase)

    @Provides
    fun signUpUseCase(mainThread : Scheduler, accountRepository: AccountRepository) = SignUpUseCase(mainThread, accountRepository)
}