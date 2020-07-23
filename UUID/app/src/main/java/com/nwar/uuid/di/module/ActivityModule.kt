package com.nwar.uuid.di.module

import com.nwar.uuid.di.module.activity.MainActivityModule
import com.nwar.uuid.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule() {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity() : MainActivity
}