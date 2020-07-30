package com.nwar.uuid.util

import com.nwar.domain.RequestResult
import io.reactivex.subscribers.DisposableSubscriber
import java.lang.NullPointerException

class Subscriber<T>(val observableAction : (T) -> Unit, val completeAction : () -> Unit, val errorAction : (Throwable?) -> Unit) : DisposableSubscriber<RequestResult<T>>() {
    override fun onComplete() {
        completeAction()
    }

    override fun onError(t: Throwable?) {
        errorAction(t)
    }

    override fun onNext(t: RequestResult<T>?) {
        if(t?.isSuccess() == true) {
            observableAction(t.value!!)
        } else {
            errorAction(NullPointerException("Observe Error"))
        }
    }
}