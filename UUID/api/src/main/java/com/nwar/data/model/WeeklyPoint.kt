package com.nwar.data.model

import com.google.gson.annotations.SerializedName

data class WeeklyPoint(
    @SerializedName("weekly_earned_point")
    val weeklyPoint: Int = 0
) {
}