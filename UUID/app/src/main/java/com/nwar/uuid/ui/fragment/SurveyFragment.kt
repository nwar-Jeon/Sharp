package com.nwar.uuid.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nwar.uuid.R
import com.nwar.uuid.databinding.FragmentMainSurveyBinding
import com.nwar.uuid.ui.adapter.SurveyListAdapter
import com.nwar.uuid.ui.base.BaseFragment
import com.nwar.uuid.viewModel.viewModel.SurveyViewModel
import javax.inject.Inject

class SurveyFragment() : BaseFragment<FragmentMainSurveyBinding>(){

    @Inject
    lateinit var mainFragment : MainFragment
    override val layoutId: Int
        get() = R.layout.fragment_main_survey

    override val viewModel: SurveyViewModel by lazy { SurveyViewModel() }

    override fun setViewModel() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeMoveFragment()
    }

    fun initRecyclerView() {
        binding.surveyRecyclerView.apply {
            adapter = SurveyListAdapter(this@SurveyFragment.context!!, viewModel)
            layoutManager = LinearLayoutManager(this@SurveyFragment.context!!)
        }
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