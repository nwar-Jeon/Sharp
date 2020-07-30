package com.nwar.uuid.viewModel.viewModel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.entity.User
import com.nwar.domain.usecase.SignInUseCase
import com.nwar.uuid.R
import com.nwar.uuid.ui.base.BaseViewModel
import com.nwar.uuid.util.Subscriber

class SignInViewModel(val signInUseCase: SignInUseCase) : BaseViewModel() {
    val id = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val signInSubscriber get() = Subscriber<User>({},{
        nextFragment.postValue(R.id.action_signInFragment_to_mainFragment)
    },{
        toast.postValue(it?.message)
    })

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_PAUSE -> nextFragment.postValue(null)
        }
    }

    fun requestLogin() {
        val user = User(id.value?:"", password.value?:"","","")
        signInUseCase.execute(user, signInSubscriber)
    }

    fun toSignUp() {
        nextFragment.postValue(R.id.action_signInFragment_to_signUpFragment)
    }
}