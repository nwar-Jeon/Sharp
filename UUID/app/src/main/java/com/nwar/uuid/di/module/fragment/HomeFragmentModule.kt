package com.nwar.uuid.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.uuid.ui.fragment.HomeFragment
import com.nwar.uuid.viewModel.factory.HomeVMF
import com.nwar.uuid.viewModel.viewModel.HomeViewModel
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule() {
    @Provides
    fun viewModel(fragment : HomeFragment, factory : HomeVMF) = ViewModelProviders.of(fragment, factory)[HomeViewModel::class.java]

    @Provides
    fun factory() = HomeVMF()
}