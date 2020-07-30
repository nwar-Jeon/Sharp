package com.nwar.data.repository

import com.nwar.data.datasource.AccountDataSource
import com.nwar.data.datasource.SurveyDataSource
import com.nwar.data.mapper.toStoreInfo
import com.nwar.data.mapper.toSurveyQuestion
import com.nwar.domain.RequestResult
import com.nwar.domain.entity.StoreInfo
import com.nwar.domain.entity.SurveyQuestion
import com.nwar.domain.repository.SurveyRepository
import com.nwar.domain.util.toRequestResult
import io.reactivex.Flowable
import io.reactivex.functions.BiFunction

class SurveyRepositoryImpl(
    val accountDataSource: AccountDataSource,
    val surveyDataSource: SurveyDataSource
) : SurveyRepository {

    override fun loadSurveyInfoList(): Flowable<RequestResult<StoreInfo>> =
        accountDataSource.getToken().flatMap { token ->
            surveyDataSource.loadSurveyInfoList(token)
                .flatMapIterable { it }
                .map { it.toStoreInfo() }
                .toRequestResult()
        }

    override fun loadSurveyQuestionList(): Flowable<RequestResult<SurveyQuestion>> {
        val tokenObservable = accountDataSource.getToken()
        val surveyIdObservable = surveyDataSource.loadSurveyInfoAtCache().map { it.id }
        return Flowable.zip(tokenObservable, surveyIdObservable, BiFunction { t1 : String, t2 : String -> t1 to t2 })
            .flatMap { pair : Pair<String, String> ->
                surveyDataSource.loadSurveyQuestionList(pair.first, pair.second)
                    .flatMapIterable { it }
                    .map { it.toSurveyQuestion() }
                    .toRequestResult()
            }
    }

    override fun saveSurveyInfoToCache(data: StoreInfo): Flowable<RequestResult<Unit>> {
        return surveyDataSource.saveSurveyInfoToCache(data).toRequestResult()
    }

    override fun submitSurvey(
        surveyResult: List<Int>
    ): Flowable<RequestResult<Unit>> {
        val tokenObservable = accountDataSource.getToken()
        val surveyId = surveyDataSource.loadSurveyInfoAtCache().map { it.id }
        return Flowable.zip(tokenObservable, surveyId, BiFunction { token : String, surveyId : String -> token to surveyId })
            .flatMap { pair : Pair<String, String> ->
                surveyDataSource.submitSurvey(pair.first, pair.second, surveyResult)
                    .toRequestResult()
            }
    }
}