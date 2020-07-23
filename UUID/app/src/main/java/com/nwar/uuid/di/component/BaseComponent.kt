package com.nwar.uuid.di.component

import com.nwar.uuid.di.module.ActivityModule
import com.nwar.uuid.di.module.AppModule
import com.nwar.uuid.di.module.ServiceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivityModule::class,
    ServiceModule::class,
    AppModule::class
])
interface BaseComponent : AndroidInjector<BaseApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application : BaseApplication) : BaseComponent
    }
}