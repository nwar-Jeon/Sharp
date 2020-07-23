package com.nwar.uuid.di.module

import com.nwar.uuid.di.module.service.WifiScanServiceModule
import com.nwar.uuid.service.WifiScanService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceModule() {
    @ContributesAndroidInjector(modules = [WifiScanServiceModule::class])
    abstract fun getWifiScanService() : WifiScanService
}