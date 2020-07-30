package com.nwar.uuid.di.module

import android.content.Context
import com.nwar.data.api.AccountAPI
import com.nwar.data.api.SurveyAPI
import com.nwar.data.api.WifiAPI
import com.nwar.data.api.createRetrofitAPI
import com.nwar.uuid.di.component.BaseApplication
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

@Module(includes = [RepositoryModule::class])
class AppModule () {
    @Singleton
    @Provides
    fun application(app : BaseApplication) = app

    @Singleton
    @Provides
    fun context (app : BaseApplication) = app as Context

    @Singleton
    @Provides
    fun accountAPI() = createRetrofitAPI(AccountAPI::class.java)

    @Singleton
    @Provides
    fun surveyAPI() = createRetrofitAPI(SurveyAPI::class.java)

    @Singleton
    @Provides
    fun wifiAPI() = createRetrofitAPI(WifiAPI::class.java)

    @Singleton
    @Provides
    fun mainScheduler() = AndroidSchedulers.mainThread()
}