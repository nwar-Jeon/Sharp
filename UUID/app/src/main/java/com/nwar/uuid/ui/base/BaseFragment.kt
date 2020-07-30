package com.nwar.uuid.ui.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.nwar.uuid.ui.lifecycle.LifecycleOwner
import dagger.android.support.DaggerFragment
import org.jetbrains.anko.support.v4.toast

abstract class BaseFragment<T : ViewDataBinding>() : DaggerFragment() {
    lateinit var binding : T
    abstract val layoutId : Int
    abstract val viewModel : BaseViewModel
    val lifecycleOwner = LifecycleOwner()
    val navController by lazy { NavHostFragment.findNavController(this) }

    abstract fun setViewModel()

    fun navigate(action : Int?) = if(action!=null && navController.currentDestination?.getAction(action)!=null) navController.navigate(action) else Unit
    fun navigateUp() = navController.navigateUp()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        lifecycleOwner.register(viewModel)
        lifecycleOwner.sendEvent(Lifecycle.Event.ON_CREATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        setViewModel()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.toast.observe(this, Observer { toast(it) })
        viewModel.navigateUp.observe(this, Observer { if(it) navigateUp() })
        viewModel.nextFragment.observe(this, Observer { if(it!=null) { navigate(it) } })
    }

    override fun onStop() {
        super.onStop()
        lifecycleOwner.sendEvent(Lifecycle.Event.ON_STOP)
    }

    override fun onStart() {
        super.onStart()
        lifecycleOwner.sendEvent(Lifecycle.Event.ON_START)
    }

    override fun onResume() {
        super.onResume()
        lifecycleOwner.sendEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleOwner.sendEvent(Lifecycle.Event.ON_DESTROY)
        lifecycleOwner.close()
    }

    override fun onPause() {
        super.onPause()
        lifecycleOwner.sendEvent(Lifecycle.Event.ON_PAUSE)
    }
}