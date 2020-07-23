package com.nwar.uuid.ui.lifecycle

import androidx.lifecycle.Lifecycle

class LifecycleOwner() {
    val array = ArrayList<LifecycleListener>()

    fun register(listener: LifecycleListener) = array.add(listener)

    fun sendEvent(event: Lifecycle.Event) = array.forEach { it.apply(event) }

    fun close() {
    }
}