package com.nwar.domain.repository

import com.nwar.domain.RequestResult
import com.nwar.domain.entity.StoreInfo
import com.nwar.domain.entity.SurveyQuestion
import io.reactivex.Flowable

interface SurveyRepository {
    fun loadSurveyInfoList() : Flowable<RequestResult<StoreInfo>>

    fun loadSurveyQuestionList(token : String, surveyId: Int) : Flowable<RequestResult<SurveyQuestion>>

    fun saveSurveyInfoToCache(data : StoreInfo)

    fun submitSurvey(surveyId : Int, surveyResult : List<Int>) : Flowable<RequestResult<Unit>>
}