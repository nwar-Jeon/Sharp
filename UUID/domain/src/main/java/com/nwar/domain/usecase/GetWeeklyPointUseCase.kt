package com.nwar.domain.usecase

import com.nwar.domain.RequestResult
import com.nwar.domain.base.UseCase
import com.nwar.domain.repository.AccountRepository
import io.reactivex.Flowable
import io.reactivex.Scheduler

class GetWeeklyPointUseCase(mainScheduler: Scheduler, val accountRepository: AccountRepository) : UseCase<Unit, Int>(mainScheduler) {
    override fun requestData(data: Unit): Flowable<RequestResult<Int>> {
        return accountRepository.getWeeklyPoint()
    }
}