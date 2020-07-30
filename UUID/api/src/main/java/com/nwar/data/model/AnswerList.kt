package com.nwar.data.model

import com.google.gson.annotations.SerializedName

data class AnswerList(
    @SerializedName("answer")
    val list : List<Int> = listOf()
) {
}