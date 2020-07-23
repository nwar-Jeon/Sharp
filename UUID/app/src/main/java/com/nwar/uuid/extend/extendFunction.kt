package com.nwar.uuid.extend

fun <T, R>T.collectOrElse(action : (T) -> R) = action(this)