package com.nwar.data.repository

import com.nwar.data.datasource.WifiDataSource
import com.nwar.domain.RequestResult
import com.nwar.domain.entity.WifiInfo
import com.nwar.domain.repository.WifiRepository
import com.nwar.domain.util.toRequestResult
import io.reactivex.Flowable

class WifiRepositoryImpl(val wifiDataSource: WifiDataSource) : WifiRepository {
    override fun sendUUIDInfo(list: Collection<WifiInfo>): Flowable<RequestResult<Unit>> {
        return wifiDataSource.sendWifiInfo(list)
            .toRequestResult()
    }
}