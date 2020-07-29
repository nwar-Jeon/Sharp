package com.nwar.data.datasource

import com.nwar.domain.entity.WifiInfo
import io.reactivex.Flowable

interface WifiDataSource {
    fun sendWifiInfo(list : Collection<WifiInfo>) : Flowable<Unit>
}