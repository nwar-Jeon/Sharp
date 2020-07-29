package com.nwar.data.cache

import com.nwar.domain.entity.StoreInfo
import io.reactivex.Flowable
import java.lang.RuntimeException

object StoreInfoCache {
    private var storeInfo : StoreInfo? = null

    fun clear() { storeInfo = null }

    fun saveSaleInfo(data : StoreInfo) { storeInfo = data }

    fun getSaleInfo() = if(storeInfo==null) Flowable.error<StoreInfo>(RuntimeException("404 Error")) else Flowable.just(storeInfo)
}