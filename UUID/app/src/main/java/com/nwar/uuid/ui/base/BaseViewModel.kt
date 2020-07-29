package com.nwar.uuid.ui.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nwar.uuid.ui.lifecycle.LifecycleListener

abstract class BaseViewModel() : ViewModel(), LifecycleListener {
    val nextFragment = MutableLiveData<Int?>()

    val navigateUp = MutableLiveData(false)

    val toast = MutableLiveData<String>()

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_DESTROY -> onDestroy()
            Lifecycle.Event.ON_STOP -> onStop()
            Lifecycle.Event.ON_PAUSE -> onPause()
            Lifecycle.Event.ON_RESUME -> onResume()
            Lifecycle.Event.ON_START -> onStart()
            Lifecycle.Event.ON_CREATE -> onCreate()
        }
    }

    open fun onCreate() {}
    open fun onStart() {}
    open fun onResume() {}
    open fun onPause() {}
    open fun onStop() {}
    open fun onDestroy() {}
}