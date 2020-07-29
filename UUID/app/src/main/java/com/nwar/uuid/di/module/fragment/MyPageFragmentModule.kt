package com.nwar.uuid.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.uuid.ui.fragment.MyPageFragment
import com.nwar.uuid.viewModel.factory.MyPageVMF
import com.nwar.uuid.viewModel.viewModel.MyPageViewModel
import dagger.Module
import dagger.Provides

@Module
class MyPageFragmentModule() {
    @Provides
    fun viewModel(fragment : MyPageFragment, factory : MyPageVMF) = ViewModelProviders.of(fragment, factory)[MyPageViewModel::class.java]

    @Provides
    fun factory() = MyPageVMF()
}