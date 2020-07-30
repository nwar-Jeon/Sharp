package com.nwar.uuid.viewModel.viewModel

import androidx.lifecycle.MutableLiveData
import com.nwar.domain.entity.User
import com.nwar.domain.usecase.SignUpUseCase
import com.nwar.uuid.ui.base.BaseViewModel
import com.nwar.uuid.util.Subscriber

class SignUpViewModel(val signUpUseCase: SignUpUseCase) : BaseViewModel() {
    val id = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val name = MutableLiveData<String>()

    val signUpSubscriber get() = Subscriber<User>({},{
        navigateUp.postValue(true)
    },{
        toast.postValue(it?.message)
    })

    fun requireSignUp() {
        val user = User(id.value?:"", password.value?:"",name.value?:"","")
        signUpUseCase.execute(user, signUpSubscriber)
    }

    override fun onCreate() {
        super.onCreate()
        navigateUp.postValue(false)
    }
}