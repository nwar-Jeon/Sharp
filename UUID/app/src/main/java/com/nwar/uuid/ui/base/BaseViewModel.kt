package com.nwar.uuid.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nwar.uuid.ui.lifecycle.LifecycleListener

abstract class BaseViewModel() : ViewModel(), LifecycleListener {
    val nextFragment = MutableLiveData<Int?>()

    val navigateUp = MutableLiveData(false)

    val toast = MutableLiveData<String>()

    open fun onCreate() {}
    open fun onStart() {}
    open fun onResume() {}
    open fun onPause() {}
    open fun onStop() {}
    open fun onDestroy() {}
}