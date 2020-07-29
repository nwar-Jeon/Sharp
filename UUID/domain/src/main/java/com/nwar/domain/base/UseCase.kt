package com.nwar.domain.base

import com.nwar.domain.RequestResult
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

abstract class UseCase<T,R>(val mainThread : Scheduler) {
    val disposable = CompositeDisposable()

    abstract fun requestData(data : T) : Flowable<RequestResult<R>>

    fun execute(data : T, subscriber : DisposableSubscriber<RequestResult<R>>) {
        val result = requestData(data).observeOn(mainThread)
            .subscribeOn(Schedulers.io())
            .subscribeWith(subscriber)
        disposable.add(result)
    }

    fun dispose() = disposable.dispose()
}