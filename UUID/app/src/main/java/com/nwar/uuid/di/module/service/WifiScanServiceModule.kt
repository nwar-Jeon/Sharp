package com.nwar.uuid.di.module.service

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.nwar.uuid.service.WifiScanService
import com.nwar.uuid.receiver.WifiScanReceiver
import com.nwar.uuid.viewModel.viewModel.WifiScanViewModel
import dagger.Module
import dagger.Provides
import org.jetbrains.anko.toast
import org.jetbrains.anko.wifiManager

@Module(includes = [WifiScanServiceInjector::class])
class WifiScanServiceModule() {
}

@Module
class WifiScanServiceInjector() {
    @Provides
    fun receiver(viewModel : WifiScanViewModel, service : WifiScanService) = WifiScanReceiver(viewModel, service.wifiManager)

    @Provides
    fun viewModel() = WifiScanViewModel()
}