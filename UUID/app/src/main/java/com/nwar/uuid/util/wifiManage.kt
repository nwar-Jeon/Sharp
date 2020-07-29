package com.nwar.uuid.util

import android.content.IntentFilter
import android.net.wifi.WifiManager

var intentFilter : IntentFilter = IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)