package com.nwar.domain.usecase

import com.nwar.domain.RequestResult
import com.nwar.domain.base.UseCase
import com.nwar.domain.repository.SurveyRepository
import io.reactivex.Flowable
import io.reactivex.Scheduler

class SubmitSurveyUseCase(mainThread : Scheduler, val surveyRepository: SurveyRepository) : UseCase<List<Int>, Unit>(mainThread) {
    override fun requestData(data: List<Int>): Flowable<RequestResult<Unit>> {
        return surveyRepository.submitSurvey(data)
    }
}