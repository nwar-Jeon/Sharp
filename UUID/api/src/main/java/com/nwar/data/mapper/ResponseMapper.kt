package com.nwar.data.mapper

import com.nwar.domain.RequestResult
import retrofit2.Response
import java.lang.RuntimeException

fun <T> Response<T>.toBodyOrThrow() : T? {
    return when(this.code()/100) {
        2 -> this.body()
        4 -> throw RuntimeException("${this.code()} Error! : ${this.message()}")
        5 -> throw RuntimeException("Server Error! : ${this.message()}")
        else -> throw RuntimeException("알 수 없는 오류")
    }
}