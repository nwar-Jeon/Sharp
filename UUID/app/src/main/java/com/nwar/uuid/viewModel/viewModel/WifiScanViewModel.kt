package com.nwar.uuid.viewModel.viewModel

import androidx.lifecycle.Lifecycle
import com.nwar.uuid.ui.lifecycle.LifecycleListener
import com.nwar.uuid.wifi.WifiInfo

class WifiScanViewModel() : LifecycleListener {

    val wifiList : MutableSet<WifiInfo> = HashSet()

    override fun apply(event: Lifecycle.Event) {
    }

    fun addWifi(item : WifiInfo) = wifiList.add(item)

    fun addAllWifi(items : Collection<WifiInfo>) = wifiList.addAll(items)
}