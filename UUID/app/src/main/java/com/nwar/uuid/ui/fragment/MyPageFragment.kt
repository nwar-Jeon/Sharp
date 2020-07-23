package com.nwar.uuid.ui.fragment

import com.nwar.uuid.R
import com.nwar.uuid.databinding.FragmentMainMypageBinding
import com.nwar.uuid.ui.base.BaseFragment
import com.nwar.uuid.ui.base.BaseViewModel
import com.nwar.uuid.viewModel.viewModel.MyPageViewModel

class MyPageFragment() : BaseFragment<FragmentMainMypageBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_main_mypage

    override val viewModel: MyPageViewModel by lazy { MyPageViewModel() }

    override fun setViewModel() {
        binding.vm = viewModel
    }
}