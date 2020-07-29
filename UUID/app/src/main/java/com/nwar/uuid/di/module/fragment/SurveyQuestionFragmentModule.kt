package com.nwar.uuid.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.uuid.ui.fragment.SurveyQuestionFragment
import com.nwar.uuid.viewModel.factory.SurveyQuestionVMF
import com.nwar.uuid.viewModel.viewModel.SurveyQuestionViewModel
import dagger.Module
import dagger.Provides

@Module
class SurveyQuestionFragmentModule() {
    @Provides
    fun vm(fragment : SurveyQuestionFragment, factory : SurveyQuestionVMF) = ViewModelProviders.of(fragment, factory)[SurveyQuestionViewModel::class.java]

    @Provides
    fun fac() = SurveyQuestionVMF()
}