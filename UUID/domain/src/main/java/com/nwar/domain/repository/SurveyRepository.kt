package com.nwar.domain.repository

import com.nwar.domain.RequestResult
import com.nwar.domain.entity.StoreInfo
import com.nwar.domain.entity.SurveyQuestion
import io.reactivex.Flowable

interface SurveyRepository {
    fun loadSurveyInfoList() : Flowable<RequestResult<StoreInfo>>

    fun loadSurveyQuestionList() : Flowable<RequestResult<SurveyQuestion>>

    fun saveSurveyInfoToCache(data : StoreInfo) : Flowable<RequestResult<Unit>>

    fun submitSurvey(surveyResult : List<Int>) : Flowable<RequestResult<Unit>>
}