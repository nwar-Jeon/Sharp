package com.nwar.data.api

import com.nwar.data.model.*
import io.reactivex.Flowable
import retrofit2.Response
import retrofit2.http.*

interface AccountAPI {
    @POST("/auth/signup")
    fun signUp(@Body data: Account): Flowable<Response<String>>

    @POST("/auth/login")
    fun signIn(@Body data: Account): Flowable<Response<Account>>

    @GET("/user/weekly_point")
    fun getWeeklyPoint(@Header("Authorization") token: String): Flowable<Response<WeeklyPoint>>
}

interface SurveyAPI {
    @GET("/survey/{survey_id}")
    fun getSurveyQuestionList(
        @Header("Authorization") token: String,
        @Path("survey_id") id: String
    ): Flowable<Response<SurveyQuestionList>>

    @POST("/survey/{survey_id}")
    fun submitSurveyResult(
        @Header("Authorization") token: String,
        @Path("survey_id") id: String,
        @Body list: AnswerList
    ): Flowable<Response<Unit>>

    @GET("/user/surveys")
    fun getSurveyList(
        @Header("Authorization") token: String
    ): Flowable<Response<SurveyInfoList>>
}

interface WifiAPI {
    @POST("/survey")
    fun sendWifiInfo(@Header("Authorization") token: String, @Body list : WifiInfoModelList) : Flowable<Response<Unit>>
}