package com.nwar.uuid.extend

import android.content.Context
import android.util.Log
import org.jetbrains.anko.wifiManager

fun Context.setWifiEnable() {
    if(!wifiManager.isWifiEnabled) wifiManager.isWifiEnabled = true
}

fun Context.wifiScan() {
    if(wifiManager.startScan()) Log.e("Scan", "Scanning...")
    else Log.e("Scan Failed", "failed")
}