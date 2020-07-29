package com.nwar.data.model

import com.google.gson.annotations.SerializedName

data class WifiInfoModel(
    @SerializedName("name")
    val ssid : String,
    @SerializedName("uuid")
    val bssid : String
) {
}