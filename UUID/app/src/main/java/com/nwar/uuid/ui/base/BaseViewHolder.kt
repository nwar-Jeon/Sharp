package com.nwar.uuid.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(val view : View) : RecyclerView.ViewHolder(view) {

    val index get() = adapterPosition

    abstract fun bind()
}