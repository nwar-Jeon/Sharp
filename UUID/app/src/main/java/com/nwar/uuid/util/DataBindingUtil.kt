package com.nwar.uuid.util

fun percentage(a: Int, b: Int) = if(b==0) 0 else ((a.toDouble() / b.toDouble()) * 100).toInt()

fun progress(a: Int, b: Int) = "$a/$b"

fun percentageString(a : Int, b : Int) = "${percentage(a,b)}%"

fun mainHomeWelcomeMessage(name : String) = "${name}님, 새로운 설문을 확인해보세요."

fun celebrateToCollectPoint(point : Int) = "이번 주에 ${point}포인트를 획득하셨어요!"

fun pointDisplayInSurveyList(point : Int) = "${point}P >"

fun displayWeeklyPoint(point: Int) = "${point}P"

fun displaySalePercentage(percent : String) ="${percent}% 할인"

fun guideSurveyListCount(count : Int) = "참여 가능한 설문이 ${count}개 있습니다."