package com.example.sbnridemo.ui.adapter

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

object CustomBindingadapter {

        @BindingAdapter("visibleGone")
        @JvmStatic
        fun showHide(view: View, isVisible: Boolean) {
            view.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
        }
}