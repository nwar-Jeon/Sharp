package com.nwar.domain.entity

import com.nwar.domain.enumerate.Satisfaction

data class SurveyQuestion(
    val question : String,
    var selection : Satisfaction? = null
) {
}