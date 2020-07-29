package com.nwar.data.datasource

import com.nwar.domain.entity.User
import io.reactivex.Flowable

interface AccountDataSource {
    fun getWeeklyPoint(token : String): Flowable<Int>

    fun signIn(account: User): Flowable<User>

    fun signUp(account: User): Flowable<User>

    fun getAccount() : Flowable<User>

    fun getToken() : Flowable<String>
}