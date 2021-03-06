package com.nwar.uuid.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.util.Log
import com.nwar.uuid.extend.collectOrElse
import com.nwar.uuid.viewModel.viewModel.WifiScanViewModel
import com.nwar.domain.entity.WifiInfo

class WifiScanReceiver(private val viewModel : WifiScanViewModel, private val wifiManager: WifiManager) : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        viewModel.addAllWifi(getWifiScanResultAsCount(2))
        viewModel.wifiList.forEach { Log.e("Wifi Info : ", "NAME : ${it.name} MAC : ${it.macAdd} RSSI : ${it.strength}") }
        viewModel.sendWifiInfo()
    }

    private fun getWifiScanResultAsCount(count : Int)
        = wifiManager.scanResults.filter {
            it.SSID.isNotEmpty()
        }.map {
        WifiInfo(
            it.SSID.trim(),
            it.BSSID.trim(),
            it.level
        )
        }.collectOrElse {
            if(it.size>=count) it.subList(0,count) else it
        }

}