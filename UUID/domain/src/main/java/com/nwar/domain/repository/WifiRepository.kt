package com.nwar.domain.repository

import com.nwar.domain.RequestResult
import com.nwar.domain.entity.WifiInfo
import io.reactivex.Flowable

interface WifiRepository {
    fun sendUUIDInfo(list : Collection<WifiInfo>) : Flowable<RequestResult<Unit>>
}