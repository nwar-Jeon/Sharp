package com.nwar.domain.usecase

import com.nwar.domain.RequestResult
import com.nwar.domain.base.UseCase
import com.nwar.domain.entity.WifiInfo
import com.nwar.domain.repository.WifiRepository
import io.reactivex.Flowable
import io.reactivex.Scheduler

class RegisterWifiInfoUseCase(mainScheduler: Scheduler, val wifiRepository: WifiRepository) : UseCase<Collection<WifiInfo>, Unit>(mainScheduler) {
    override fun requestData(data: Collection<WifiInfo>): Flowable<RequestResult<Unit>> {
        return wifiRepository.sendUUIDInfo(data)
    }
}