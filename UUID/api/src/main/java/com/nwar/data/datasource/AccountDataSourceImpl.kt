package com.nwar.data.datasource

import com.nwar.data.api.AccountAPI
import com.nwar.data.cache.AccountCache
import com.nwar.data.mapper.toAccount
import com.nwar.data.mapper.toBodyOrThrow
import com.nwar.data.mapper.toInt
import com.nwar.data.mapper.toUser
import com.nwar.domain.entity.User
import io.reactivex.Flowable

class AccountDataSourceImpl(val api : AccountAPI, val accountCache : AccountCache) : AccountDataSource {
    override fun getWeeklyPoint(token : String): Flowable<Int> {
        return api.getWeeklyPoint(token)
            .map { it.toBodyOrThrow()?.toInt() }
    }

    override fun signIn(account : User): Flowable<User> {
        return api.signIn(account.toAccount())
            .map { it.toBodyOrThrow()?.toUser() }
            .map { it.apply { accountCache.saveUser(this) } }
    }

    override fun signUp(account : User): Flowable<User> {
        return api.signUp(account.toAccount())
            .map { it.toBodyOrThrow()?.toUser() }
    }

    override fun getAccount(): Flowable<User> {
        return accountCache.loadUser()
    }

    override fun getToken(): Flowable<String> {
        return accountCache.loadToken()
    }
}