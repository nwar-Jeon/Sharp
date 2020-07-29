package com.nwar.data.datasource

import com.nwar.data.model.Question
import com.nwar.data.model.SurveyInfo
import com.nwar.domain.entity.StoreInfo
import io.reactivex.Flowable

interface SurveyDataSource {
    fun loadSurveyInfoList(token: String) : Flowable<List<SurveyInfo>>

    fun loadSurveyQuestionList(token : String, surveyId : Int) : Flowable<List<Question>>

    fun saveSurveyInfoToCache(surveyInfo: StoreInfo)

    fun submitSurvey(token : String, surveyId: Int, surveyResult : List<Int>) : Flowable<Unit>

    fun loadSurveyInfoAtCache() : Flowable<StoreInfo>
}