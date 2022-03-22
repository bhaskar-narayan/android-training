package com.carmedia2p0.capture.utils

import android.app.Activity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.carmedia2p0.capture.R
import com.carmedia2p0.capture.ui.base.viewmodel.BaseViewModel
import com.carmedia2p0.capture.ui.main.MainViewModel
import com.carmedia2p0.capture.ui.splash.SplashViewModel

@BindingAdapter("viewModel", "text")
fun setMyText(textView: TextView, viewModel: BaseViewModel, text: String) {
    when (viewModel) {
        is MainViewModel -> textView.text = text
        is SplashViewModel -> textView.text = text
    }
}

fun Activity.addDots(currentPage: Int, item: Int, linerLayout: LinearLayout) {
    val dots = arrayOfNulls<ImageView>(item)
    linerLayout.removeAllViews()
    for (i in 0 until item) {
        dots[i] = ImageView(this)
        if (i == 0) {
            dots[i]?.setPadding(0, 0, 0, 0)
        } else {
            dots[i]?.setPadding(40, 0, 0, 0)
        }

        linerLayout.addView(dots[i])
    }
    if (dots.isNotEmpty()) {
        dots[currentPage]?.setImageResource(R.drawable.dot_fill_black)
    }
}
