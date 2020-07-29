package com.nwar.data.model

import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("heading")
    val question : String
) {
}