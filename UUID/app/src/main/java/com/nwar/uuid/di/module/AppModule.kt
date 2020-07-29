package com.nwar.uuid.di.module

import android.content.Context
import com.nwar.data.api.AccountAPI
import com.nwar.data.api.SurveyAPI
import com.nwar.data.api.createRetrofitAPI
import com.nwar.uuid.di.component.BaseApplication
import dagger.Module
import javax.inject.Singleton

@Module
class AppModule () {
    @Singleton
    fun application(app : BaseApplication) = app

    @Singleton
    fun context (app : BaseApplication) = app as Context

    @Singleton
    fun accountAPI() = createRetrofitAPI(AccountAPI::class.java)

    @Singleton
    fun surveyAPI() = createRetrofitAPI(SurveyAPI::class.java)
}