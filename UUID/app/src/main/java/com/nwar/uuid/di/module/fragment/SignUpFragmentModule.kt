package com.nwar.uuid.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.uuid.ui.fragment.SignUpFragment
import com.nwar.uuid.viewModel.factory.SignUpVMF
import com.nwar.uuid.viewModel.viewModel.SignUpViewModel
import dagger.Module
import dagger.Provides

@Module
class SignUpFragmentModule() {
    @Provides
    fun viewModel(fragment : SignUpFragment, factory : SignUpVMF) = ViewModelProviders.of(fragment, factory)[SignUpViewModel::class.java]

    @Provides
    fun factory() = SignUpVMF()
}