package com.nwar.data.model

import com.google.gson.annotations.SerializedName

data class WifiInfoModelList(
    @SerializedName("stores")
    val list : Collection<WifiInfoModel> = listOf()
) {
}