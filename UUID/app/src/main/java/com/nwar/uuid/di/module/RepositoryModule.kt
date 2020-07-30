package com.nwar.uuid.di.module

import com.nwar.data.datasource.AccountDataSource
import com.nwar.data.datasource.SurveyDataSource
import com.nwar.data.datasource.WifiDataSource
import com.nwar.data.repository.AccountRepositoryImpl
import com.nwar.data.repository.SurveyRepositoryImpl
import com.nwar.data.repository.WifiRepositoryImpl
import com.nwar.domain.repository.AccountRepository
import com.nwar.domain.repository.SurveyRepository
import com.nwar.domain.repository.WifiRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataSourceModule::class])
class RepositoryModule() {
    @Singleton
    @Provides
    fun accountRepository(accountDataSource: AccountDataSource) : AccountRepository = AccountRepositoryImpl(accountDataSource)

    @Singleton
    @Provides
    fun surveyRepository(accountDataSource: AccountDataSource, surveyDataSource: SurveyDataSource) : SurveyRepository = SurveyRepositoryImpl(accountDataSource, surveyDataSource)

    @Singleton
    @Provides
    fun wifiRepository(wifiDataSource: WifiDataSource) : WifiRepository = WifiRepositoryImpl(wifiDataSource)
}