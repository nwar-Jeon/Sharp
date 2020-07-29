package com.nwar.uuid.ui.fragment

import com.nwar.uuid.R
import com.nwar.uuid.databinding.FragmentSignupBinding
import com.nwar.uuid.ui.base.BaseFragment
import com.nwar.uuid.ui.base.BaseViewModel
import com.nwar.uuid.viewModel.viewModel.SignUpViewModel
import javax.inject.Inject

class SignUpFragment() : BaseFragment<FragmentSignupBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_signup

    @Inject
    override lateinit var viewModel: SignUpViewModel

    override fun setViewModel() {
        binding.vm = viewModel
    }
}