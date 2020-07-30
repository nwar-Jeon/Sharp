package com.nwar.domain.util

import com.nwar.domain.RequestResult
import io.reactivex.Flowable

fun <T> Flowable<T>.toRequestResult() = this.map { RequestResult.success(it) }.doOnError { RequestResult.failure<T>(it) }