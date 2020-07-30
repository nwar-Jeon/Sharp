package com.nwar.uuid.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nwar.domain.usecase.GetSurveyQuestionListUseCase
import com.nwar.domain.usecase.SubmitSurveyUseCase

class SurveyQuestionVMF(val getSurveyQuestionListUseCase: GetSurveyQuestionListUseCase, val submitSurveyUseCase: SubmitSurveyUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = modelClass.getConstructor(getSurveyQuestionListUseCase::class.java, submitSurveyUseCase::class.java).newInstance(getSurveyQuestionListUseCase,submitSurveyUseCase)
}