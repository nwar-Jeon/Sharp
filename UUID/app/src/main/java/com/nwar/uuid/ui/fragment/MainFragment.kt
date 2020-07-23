package com.nwar.uuid.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.nwar.uuid.R
import com.nwar.uuid.databinding.FragmentMainBinding
import com.nwar.uuid.ui.activity.MainActivity
import com.nwar.uuid.ui.base.BaseFragment
import com.nwar.uuid.viewModel.viewModel.MainFragmentViewModel
import javax.inject.Inject

class MainFragment() : BaseFragment<FragmentMainBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_main

    override val viewModel: MainFragmentViewModel by lazy { MainFragmentViewModel() }

    override fun setViewModel() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NavigationUI.setupWithNavController(binding.bottomNavigationView, Navigation.findNavController(view.findViewById(R.id.main_fragment_fragment)))
    }
}