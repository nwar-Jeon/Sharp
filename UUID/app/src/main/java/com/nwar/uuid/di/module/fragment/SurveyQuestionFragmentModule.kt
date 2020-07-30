package com.nwar.uuid.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.domain.repository.SurveyRepository
import com.nwar.domain.usecase.GetSurveyQuestionListUseCase
import com.nwar.domain.usecase.SubmitSurveyUseCase
import com.nwar.uuid.ui.fragment.SurveyQuestionFragment
import com.nwar.uuid.viewModel.factory.SurveyQuestionVMF
import com.nwar.uuid.viewModel.viewModel.SurveyQuestionViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
class SurveyQuestionFragmentModule() {
    @Provides
    fun vm(fragment : SurveyQuestionFragment, factory : SurveyQuestionVMF) = ViewModelProviders.of(fragment, factory)[SurveyQuestionViewModel::class.java]

    @Provides
    fun fac(getSurveyQuestionListUseCase: GetSurveyQuestionListUseCase, submitSurveyUseCase: SubmitSurveyUseCase) = SurveyQuestionVMF(getSurveyQuestionListUseCase, submitSurveyUseCase)

    @Provides
    fun getSurveyQuestionListUseCase(mainScheduler: Scheduler, surveyRepository: SurveyRepository) = GetSurveyQuestionListUseCase(mainScheduler, surveyRepository)

    @Provides
    fun submitSurveyUseCase(mainScheduler: Scheduler, surveyRepository: SurveyRepository) = SubmitSurveyUseCase(mainScheduler, surveyRepository)
}