package com.nwar.domain.usecase

import com.nwar.domain.RequestResult
import com.nwar.domain.base.UseCase
import com.nwar.domain.entity.User
import com.nwar.domain.repository.AccountRepository
import io.reactivex.Flowable
import io.reactivex.Scheduler

class SignInUseCase(mainThread : Scheduler, val accountRepository: AccountRepository) : UseCase<User, User>(mainThread) {
    override fun requestData(data: User): Flowable<RequestResult<User>> {
        return accountRepository.signIn(data)
    }
}