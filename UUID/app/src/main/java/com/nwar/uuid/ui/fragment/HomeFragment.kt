package com.nwar.uuid.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.nwar.uuid.R
import com.nwar.uuid.databinding.FragmentMainHomeBinding
import com.nwar.uuid.ui.adapter.SaleBannerAdapter
import com.nwar.uuid.ui.base.BaseFragment
import com.nwar.uuid.viewModel.viewModel.HomeViewModel
import javax.inject.Inject

class HomeFragment() : BaseFragment<FragmentMainHomeBinding>() {

    @Inject
    lateinit var mainFragment : MainFragment

    override val layoutId: Int
        get() = R.layout.fragment_main_home

    @Inject
    override lateinit var viewModel: HomeViewModel

    override fun setViewModel() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeViewpager.adapter = SaleBannerAdapter(this.context!!,viewModel)
        observeMoveFragment()
    }

    fun observeMoveFragment() {
        viewModel.nextFragment.observe(this, Observer {
            when(it) {
                R.id.action_mainFragment_to_surveyQuestionFragment -> requireMoveToSurveyQuestionFragment(it)
            }
        })
    }

    fun requireMoveToSurveyQuestionFragment(action : Int) {
        mainFragment.navigate(action)
    }
}