package com.nwar.uuid.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.uuid.ui.fragment.SurveyFragment
import com.nwar.uuid.viewModel.factory.SurveyVMF
import com.nwar.uuid.viewModel.viewModel.SurveyViewModel
import dagger.Module
import dagger.Provides

@Module
class SurveyFragmentModule() {
    @Provides
    fun viewModel(fragment : SurveyFragment, factory : SurveyVMF) = ViewModelProviders.of(fragment, factory)[SurveyViewModel::class.java]

    @Provides
    fun factory() = SurveyVMF()
}