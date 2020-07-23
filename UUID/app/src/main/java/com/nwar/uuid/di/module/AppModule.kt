package com.nwar.uuid.di.module

import android.content.Context
import com.nwar.uuid.di.component.BaseApplication
import dagger.Module

@Module
class AppModule () {
    fun application(app : BaseApplication) = app

    fun context (app : BaseApplication) = app as Context
}