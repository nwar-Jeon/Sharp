package com.nwar.uuid.ui.fragment

import android.os.Bundle
import android.view.View
import com.nwar.uuid.R
import com.nwar.uuid.databinding.FragmentMainHomeBinding
import com.nwar.uuid.ui.adapter.SaleBannerAdapter
import com.nwar.uuid.ui.base.BaseFragment
import com.nwar.uuid.viewModel.viewModel.HomeViewModel

class HomeFragment() : BaseFragment<FragmentMainHomeBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_main_home

    override val viewModel: HomeViewModel by lazy { HomeViewModel() }

    override fun setViewModel() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeViewpager.adapter = SaleBannerAdapter(this.context!!)
    }
}