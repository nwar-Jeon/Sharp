package com.nwar.uuid.ui.lifecycle

import androidx.lifecycle.Lifecycle

interface LifecycleListener {
    fun apply(event : Lifecycle.Event)
}