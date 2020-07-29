package com.nwar.data.datasource

import com.nwar.data.api.SurveyAPI
import com.nwar.data.cache.StoreInfoCache
import com.nwar.data.mapper.toBodyOrThrow
import com.nwar.data.model.Question
import com.nwar.data.model.SurveyInfo
import com.nwar.domain.entity.StoreInfo
import io.reactivex.Flowable

class SurveyDataSourceImpl(val api : SurveyAPI, val storeInfoCache : StoreInfoCache) : SurveyDataSource {
    override fun loadSurveyInfoList(token : String): Flowable<List<SurveyInfo>> {
        return api.getSurveyList(token)
            .map { it.toBodyOrThrow()?.list }
    }

    override fun loadSurveyQuestionList(token : String, surveyId : Int): Flowable<List<Question>> {
        return api.getSurveyQuestionList(token, surveyId)
            .map { it.toBodyOrThrow()?.list }
    }

    override fun saveSurveyInfoToCache(storeInfo: StoreInfo) {
        storeInfoCache.saveSaleInfo(storeInfo)
    }

    override fun loadSurveyInfoAtCache(): Flowable<StoreInfo> {
        return storeInfoCache.getSaleInfo()
    }

    override fun submitSurvey(token : String, surveyId: Int, surveyResult : List<Int>): Flowable<Unit> {
        return api.submitSurveyResult(token, surveyId, surveyResult)
            .map { it.toBodyOrThrow() }
    }
}

