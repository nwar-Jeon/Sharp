package com.nwar.data.model

import com.google.gson.annotations.SerializedName

data class SurveyInfo(
    @SerializedName("survey_id") val id : Int,
    @SerializedName("store_name") val name : String,
    @SerializedName("discount_amount") val sales : String,
    @SerializedName("point") val point : Int
) {
}