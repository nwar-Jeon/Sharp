package com.nwar.uuid.bindingAdapter

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.nwar.uuid.ui.base.BaseAdapter

@BindingAdapter("bind")
fun RecyclerView.itemInit(list : List<Any>?) {
    (this.adapter as BaseAdapter<*>).changeItem(list ?: listOf())
}

@BindingAdapter("bind")
fun ViewPager2.itemInit(list : List<Any>?) {
    (this.adapter as BaseAdapter<*>).changeItem(list ?: listOf())
}