package com.nwar.data.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val baseURL = "http://uuid.ap-northeast-2.elasticbeanstalk.com/"

val retrofit = Retrofit.Builder()
    .baseUrl(baseURL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()

fun <T>createRetrofitAPI(model : Class<T>) = retrofit.create(model)