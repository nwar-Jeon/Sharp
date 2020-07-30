package com.nwar.domain.usecase

import com.nwar.domain.RequestResult
import com.nwar.domain.base.UseCase
import com.nwar.domain.entity.StoreInfo
import com.nwar.domain.repository.SurveyRepository
import io.reactivex.Flowable
import io.reactivex.Scheduler

class GetSaleInfoListUseCase(mainThread : Scheduler, val surveyRepository : SurveyRepository) : UseCase<Unit, StoreInfo>(mainThread) {
    override fun requestData(data: Unit): Flowable<RequestResult<StoreInfo>> {
        return surveyRepository.loadSurveyInfoList()
    }
}