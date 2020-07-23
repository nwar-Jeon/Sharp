package com.nwar.uuid.ui.customView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.nwar.uuid.R

class LoginButton(val mContext : Context, val attributeSet: AttributeSet?, val defStyle : Int) : ConstraintLayout(mContext, attributeSet, defStyle) {
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context) : this(context, null, 0)
    init {
        addView(LayoutInflater.from(mContext).inflate(R.layout.view_login_button, this, false))
    }
}