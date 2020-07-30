package com.nwar.uuid.di.module

import com.nwar.data.api.AccountAPI
import com.nwar.data.api.SurveyAPI
import com.nwar.data.api.WifiAPI
import com.nwar.data.cache.AccountCache
import com.nwar.data.cache.StoreInfoCache
import com.nwar.data.datasource.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule() {
    @Singleton
    @Provides
    fun accountDataSource(accountAPI: AccountAPI) : AccountDataSource = AccountDataSourceImpl(accountAPI, AccountCache)

    @Singleton
    @Provides
    fun surveyDataSource(surveyAPI: SurveyAPI) : SurveyDataSource = SurveyDataSourceImpl(surveyAPI, StoreInfoCache)

    @Singleton
    @Provides
    fun wifiDataSource(wifiAPI: WifiAPI) : WifiDataSource = WifiDataSourceImpl(wifiAPI, AccountCache)
}