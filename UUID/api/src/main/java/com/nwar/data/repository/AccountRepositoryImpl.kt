package com.nwar.data.repository

import com.nwar.data.datasource.AccountDataSource
import com.nwar.domain.RequestResult
import com.nwar.domain.entity.User
import com.nwar.domain.repository.AccountRepository
import com.nwar.domain.util.toRequestResult
import io.reactivex.Flowable

class AccountRepositoryImpl(val accountDataSource: AccountDataSource) : AccountRepository {
    override fun getWeeklyPoint(): Flowable<RequestResult<Int>> {
        return accountDataSource.getToken().flatMap { token ->
            accountDataSource.getWeeklyPoint(token).toRequestResult()
        }
    }

    override fun signIn(user : User): Flowable<RequestResult<User>> {
        return accountDataSource.signIn(user).toRequestResult()
    }

    override fun signUp(user : User): Flowable<RequestResult<User>> {
        return accountDataSource.signUp(user).toRequestResult()
    }
}