package com.nwar.uuid.viewModel.viewModel

import androidx.lifecycle.Lifecycle
import com.nwar.uuid.R
import com.nwar.uuid.ui.base.BaseViewModel

class SignInViewModel() : BaseViewModel() {
    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_PAUSE -> nextFragment.postValue(null)
        }
    }

    fun requestLogin() {
        nextFragment.postValue(R.id.action_signInFragment_to_mainFragment)
    }

    fun toSignUp() {
        nextFragment.postValue(R.id.action_signInFragment_to_signUpFragment)
    }
}