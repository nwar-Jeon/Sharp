package com.nwar.uuid.viewModel.viewModel

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.nwar.uuid.ui.lifecycle.LifecycleListener
import com.nwar.domain.entity.WifiInfo
import com.nwar.domain.usecase.RegisterWifiInfoUseCase
import com.nwar.uuid.util.Subscriber

class WifiScanViewModel(val registerWifiInfoUseCase: RegisterWifiInfoUseCase) : LifecycleListener {

    var wifiList: MutableSet<WifiInfo> = HashSet()
    val toast = MutableLiveData<String>()

    val wifiListSubscriber
        get() = Subscriber<Unit>({}, {
            wifiList = HashSet()
        }, {
            Log.e(this.javaClass.simpleName, it?.message ?: "")
        })

    override fun apply(event: Lifecycle.Event) {
    }

    fun addWifi(item: WifiInfo) = wifiList.add(item)

    fun addAllWifi(items: Collection<WifiInfo>) {
        wifiList.addAll(items)
    }

    fun sendWifiInfo() {
        registerWifiInfoUseCase.execute(wifiList, wifiListSubscriber)
    }
}