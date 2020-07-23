package com.nwar.uuid.ui.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : ViewDataBinding>(val context: Context) : RecyclerView.Adapter<BaseViewHolder>() {
    abstract val layoutId : Int
    lateinit var binding : T
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, parent, false)
        return createViewHolder(binding, viewType)
    }

    abstract fun createViewHolder(binding : T, viewType: Int) : BaseViewHolder
}