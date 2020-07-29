package com.nwar.data.repository

import com.nwar.data.datasource.AccountDataSource
import com.nwar.data.datasource.SurveyDataSource
import com.nwar.data.mapper.toStoreInfo
import com.nwar.data.mapper.toSurveyQuestion
import com.nwar.domain.RequestResult
import com.nwar.domain.entity.StoreInfo
import com.nwar.domain.entity.SurveyQuestion
import com.nwar.domain.repository.SurveyRepository
import io.reactivex.Flowable
import io.reactivex.functions.BiFunction

class SurveyRepositoryImpl(val accountDataSource: AccountDataSource, val surveyDataSource: SurveyDataSource) : SurveyRepository {

    override fun loadSurveyInfoList(): Flowable<RequestResult<StoreInfo>>
        = accountDataSource.getToken().flatMap { token ->
            surveyDataSource.loadSurveyInfoList(token)
                .flatMapIterable { it }
                .map { it.toStoreInfo() }
                .map { RequestResult.success(it) }
                .doOnError { RequestResult.failure<StoreInfo>(it) }
        }

    override fun loadSurveyQuestionList(token: String, surveyId: Int): Flowable<RequestResult<SurveyQuestion>> {
        val tokenObservable = accountDataSource.getToken()
        val surveyIdObservable = surveyDataSource.loadSurveyInfoAtCache().map { it.id }
        return Flowable.zip(tokenObservable, surveyIdObservable, BiFunction { t1, t2 -> t1 to t2 })
            .flatMap { pair ->
                surveyDataSource.loadSurveyQuestionList(pair.first, pair.second)
                    .flatMapIterable { it }
                    .map { it.toSurveyQuestion() }
                    .map { RequestResult.success(it) }
                    .doOnError { RequestResult.failure<StoreInfo>(it) }
            }
    }

    override fun saveSurveyInfoToCache(data : StoreInfo) {
        surveyDataSource.saveSurveyInfoToCache(data)
    }

    override fun submitSurvey(surveyId : Int, surveyResult : List<Int>): Flowable<RequestResult<Unit>>
        = accountDataSource.getToken().flatMap { token ->
            surveyDataSource.submitSurvey(token, surveyId, surveyResult)
                .map { RequestResult.success(it) }
                .doOnError { RequestResult.failure<Unit>(it) }
        }
}