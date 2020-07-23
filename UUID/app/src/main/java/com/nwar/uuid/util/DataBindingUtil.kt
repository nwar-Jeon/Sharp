package com.nwar.uuid.util

fun percentage(a: Int, b: Int) = ((a.toDouble() / b.toDouble()) * 100).toInt()

fun progress(a: Int, b: Int) = "$a/$b"

fun percentageString(a : Int, b : Int) = "${percentage(a,b)}%"

fun mainHomeWelcomMessage(name : String) = "${name}님, 새로운 설문을 확인해보세요."

fun celebrateToCollectPoint(point : Int) = "이번 주에 ${point}포인트를 획득하셨어요!"