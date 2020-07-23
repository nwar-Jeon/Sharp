package com.nwar.uuid.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.nwar.uuid.R
import com.nwar.uuid.databinding.FragmentLoginBinding
import com.nwar.uuid.ui.base.BaseFragment
import com.nwar.uuid.viewModel.viewModel.SignInViewModel

class SignInFragment() : BaseFragment<FragmentLoginBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_login

    override val viewModel: SignInViewModel by lazy { SignInViewModel() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.nextFragment.observe(this, Observer {
            navigate(it)
        })
    }

    override fun setViewModel() {
        binding.vm = viewModel
    }
}