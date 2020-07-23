package com.nwar.uuid.viewModel.viewModel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.nwar.uuid.ui.base.BaseViewModel

class HomeViewModel() : BaseViewModel() {

    val name = MutableLiveData<String>("전승민")

    val collectPointInWeek = MutableLiveData<Int>(10)

    override fun apply(event: Lifecycle.Event) {

    }
}