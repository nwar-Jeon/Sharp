package com.nwar.uuid.di.module.activity

import android.content.Intent
import com.nwar.uuid.di.module.fragment.MainFragmentModule
import com.nwar.uuid.service.WifiScanService
import com.nwar.uuid.ui.activity.MainActivity
import com.nwar.uuid.ui.fragment.MainFragment
import com.nwar.uuid.ui.fragment.SignInFragment
import com.nwar.uuid.ui.fragment.SignUpFragment
import com.nwar.uuid.ui.fragment.SurveyQuestionFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [MainActivityInjector::class])
abstract class MainActivityModule() {
    @ContributesAndroidInjector
    abstract fun signinFragment() : SignInFragment

    @ContributesAndroidInjector
    abstract fun signupFragment() : SignUpFragment

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun mainFragment() : MainFragment

    @ContributesAndroidInjector
    abstract fun surveyQuestionFragment() : SurveyQuestionFragment
}


@Module
class MainActivityInjector() {
    @Provides
    fun wifiScanServiceIntent(activity : MainActivity) = Intent(activity, WifiScanService::class.java)
}