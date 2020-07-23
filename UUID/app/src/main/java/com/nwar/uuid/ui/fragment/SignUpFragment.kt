package com.nwar.uuid.ui.fragment

import com.nwar.uuid.R
import com.nwar.uuid.databinding.FragmentSignupBinding
import com.nwar.uuid.ui.base.BaseFragment
import com.nwar.uuid.ui.base.BaseViewModel
import com.nwar.uuid.viewModel.viewModel.SignUpViewModel

class SignUpFragment() : BaseFragment<FragmentSignupBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_signup

    override val viewModel: SignUpViewModel by lazy { SignUpViewModel() }

    override fun setViewModel() {
        binding.vm = viewModel
    }
}