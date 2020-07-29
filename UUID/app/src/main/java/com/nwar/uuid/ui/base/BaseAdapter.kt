package com.nwar.uuid.ui.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : ViewDataBinding>(val context: Context) : RecyclerView.Adapter<BaseViewHolder>() {
    var itemList : List<Any> = arrayListOf()
    abstract val layoutId : Int
    lateinit var binding : T

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, parent, false)
        return createViewHolder(binding, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind()
    }

    abstract fun createViewHolder(binding : T, viewType: Int) : BaseViewHolder

    fun changeItem(list : List<Any>) {
        val temp = itemList.toList()
        itemList = list
        (temp.size until itemList.size).forEach {
            notifyItemInserted(it)
        }
    }
}