package com.nwar.data.model

import com.google.gson.annotations.SerializedName

data class SurveyQuestionList(
    @SerializedName("questions")
    val list : List<Question> = listOf()
) {
}