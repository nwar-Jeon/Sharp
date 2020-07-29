package com.nwar.data.cache

import com.nwar.domain.entity.User
import io.reactivex.Flowable
import java.lang.RuntimeException

object AccountCache {
    private var user : User? = null

    fun clear() { user = null }

    fun saveUser(data : User) {
        user = data
    }

    fun loadUser() = if(user==null) Flowable.error<User>(RuntimeException("UserInfo Not Found")) else Flowable.just(user)

    fun loadToken() = if(user?.token==null) Flowable.error<String>(RuntimeException("access token Not Found")) else Flowable.just(user?.token)

    fun loadName() = if(user?.name==null) Flowable.error<String>(RuntimeException("user name Not Fount")) else Flowable.just(user?.name)
}