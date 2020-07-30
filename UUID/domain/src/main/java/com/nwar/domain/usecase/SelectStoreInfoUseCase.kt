package com.nwar.domain.usecase

import com.nwar.domain.RequestResult
import com.nwar.domain.base.UseCase
import com.nwar.domain.entity.StoreInfo
import com.nwar.domain.repository.SurveyRepository
import io.reactivex.Flowable
import io.reactivex.Scheduler

class SelectStoreInfoUseCase(mainThread : Scheduler, val surveyRepository: SurveyRepository) : UseCase<StoreInfo, Unit>(mainThread) {
    override fun requestData(data: StoreInfo): Flowable<RequestResult<Unit>> {
        return surveyRepository.saveSurveyInfoToCache(data)
    }
}