package com.nwar.data.mapper

import com.nwar.data.model.Account
import com.nwar.data.model.Question
import com.nwar.data.model.SurveyInfo
import com.nwar.data.model.WeeklyPoint
import com.nwar.domain.entity.StoreInfo
import com.nwar.domain.entity.SurveyQuestion
import com.nwar.domain.entity.User

fun Account.toUser() = User(this.id, this.password, this.username, "Bearer ${this.token}")

fun Question.toSurveyQuestion() = SurveyQuestion(this.question)

fun SurveyInfo.toStoreInfo() = StoreInfo(this.id, "", this.name, this.sales, this.point)

fun WeeklyPoint.toInt() = this.weeklyPoint