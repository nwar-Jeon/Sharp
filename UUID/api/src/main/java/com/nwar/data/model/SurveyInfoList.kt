package com.nwar.data.model

import com.google.gson.annotations.SerializedName

data class SurveyInfoList(
    @SerializedName("surveys")
    val list : List<SurveyInfo> = listOf()
) {
}