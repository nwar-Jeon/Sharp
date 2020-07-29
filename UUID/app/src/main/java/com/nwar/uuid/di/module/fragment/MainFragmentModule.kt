package com.nwar.uuid.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.uuid.ui.fragment.HomeFragment
import com.nwar.uuid.ui.fragment.MainFragment
import com.nwar.uuid.ui.fragment.MyPageFragment
import com.nwar.uuid.ui.fragment.SurveyFragment
import com.nwar.uuid.viewModel.factory.MainFragmentVMF
import com.nwar.uuid.viewModel.viewModel.MainFragmentViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [MainFragmentInjector::class])
abstract class MainFragmentModule() {
    @ContributesAndroidInjector(modules = [SurveyFragmentModule::class])
    abstract fun surveyFragment() : SurveyFragment

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun homeFragment() : HomeFragment

    @ContributesAndroidInjector(modules = [MyPageFragmentModule::class])
    abstract fun myPageFragment() : MyPageFragment
}

@Module
class MainFragmentInjector() {
    @Provides
    fun vm(fragment : MainFragment, factory : MainFragmentVMF) = ViewModelProviders.of(fragment, factory)[MainFragmentViewModel::class.java]

    @Provides
    fun f() = MainFragmentVMF()
}