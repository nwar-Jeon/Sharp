package com.nwar.data.datasource

import com.nwar.data.api.WifiAPI
import com.nwar.data.cache.AccountCache
import com.nwar.data.mapper.toBodyOrThrow
import com.nwar.data.mapper.toWifiInfoModel
import com.nwar.data.model.WifiInfoModelList
import com.nwar.domain.entity.WifiInfo
import io.reactivex.Flowable

class WifiDataSourceImpl(val api : WifiAPI, val accountCache : AccountCache) : WifiDataSource {
    override fun sendWifiInfo(list: Collection<WifiInfo>): Flowable<Unit> {
        return accountCache.loadToken().flatMap { token ->
            api.sendWifiInfo(token, WifiInfoModelList(list.map { it.toWifiInfoModel() }))
                .map { it.toBodyOrThrow() }
        }
    }
}