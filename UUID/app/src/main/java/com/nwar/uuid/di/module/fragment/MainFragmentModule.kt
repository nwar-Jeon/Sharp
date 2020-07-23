package com.nwar.uuid.di.module.fragment

import com.nwar.uuid.ui.fragment.HomeFragment
import com.nwar.uuid.ui.fragment.MyPageFragment
import com.nwar.uuid.ui.fragment.SurveyFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [MainFragmentInjector::class])
abstract class MainFragmentModule() {
    @ContributesAndroidInjector
    abstract fun surveyFragment() : SurveyFragment

    @ContributesAndroidInjector
    abstract fun homeFragment() : HomeFragment

    @ContributesAndroidInjector
    abstract fun myPageFragment() : MyPageFragment
}

@Module
class MainFragmentInjector() {

}