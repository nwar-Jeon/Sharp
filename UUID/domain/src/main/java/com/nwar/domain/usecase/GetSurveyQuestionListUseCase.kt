package com.nwar.domain.usecase

import com.nwar.domain.RequestResult
import com.nwar.domain.base.UseCase
import com.nwar.domain.entity.SurveyQuestion
import com.nwar.domain.repository.SurveyRepository
import io.reactivex.Flowable
import io.reactivex.Scheduler

class GetSurveyQuestionListUseCase(
    mainScheduler: Scheduler,
    val surveyRepository: SurveyRepository
) : UseCase<Unit, SurveyQuestion>(mainScheduler) {
    override fun requestData(data: Unit): Flowable<RequestResult<SurveyQuestion>> {
        return surveyRepository.loadSurveyQuestionList()
    }
}