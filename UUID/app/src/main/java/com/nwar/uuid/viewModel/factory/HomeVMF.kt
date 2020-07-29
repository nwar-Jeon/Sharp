package com.nwar.uuid.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomeVMF() : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = modelClass.getConstructor().newInstance()
}