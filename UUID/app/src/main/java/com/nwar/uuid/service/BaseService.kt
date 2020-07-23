package com.nwar.uuid.service


import androidx.lifecycle.Lifecycle
import com.nwar.uuid.ui.lifecycle.LifecycleListener
import com.nwar.uuid.ui.lifecycle.LifecycleOwner
import dagger.android.DaggerIntentService

abstract class BaseService(name : String) : DaggerIntentService(name) {
    val lifecycleOwner = LifecycleOwner()
    abstract val viewModel : LifecycleListener

    override fun onCreate() {
        super.onCreate()
        lifecycleOwner.register(viewModel)
        lifecycleOwner.sendEvent(Lifecycle.Event.ON_CREATE)
        lifecycleOwner.sendEvent(Lifecycle.Event.ON_START)
        lifecycleOwner.sendEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleOwner.sendEvent(Lifecycle.Event.ON_PAUSE)
        lifecycleOwner.sendEvent(Lifecycle.Event.ON_STOP)
        lifecycleOwner.sendEvent(Lifecycle.Event.ON_DESTROY)
        lifecycleOwner.close()
    }
}