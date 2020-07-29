package com.nwar.domain

class RequestResult<T>(val value : T? = null, val exception : Throwable? = null) {
    companion object {
        fun <T>success(data : T) = RequestResult(data)
        fun <T>failure(exception: Throwable) = RequestResult<T>(exception = exception)
    }

    fun isSuccess() = value!=null && exception==null

    fun isFailure() = value==null && exception!=null
}