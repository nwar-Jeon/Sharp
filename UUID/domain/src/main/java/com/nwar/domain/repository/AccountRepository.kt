package com.nwar.domain.repository

import com.nwar.domain.RequestResult
import com.nwar.domain.entity.User
import io.reactivex.Flowable

interface AccountRepository {
    fun getWeeklyPoint() : Flowable<RequestResult<Int>>

    fun signIn(user : User) : Flowable<RequestResult<User>>

    fun signUp(user : User) : Flowable<RequestResult<User>>
}