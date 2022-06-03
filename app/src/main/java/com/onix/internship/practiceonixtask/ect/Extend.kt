package com.onix.internship.practiceonixtask.ect

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.onix.internship.practiceonixtask.R
import com.onix.internship.practiceonixtask.ScreenState

@BindingAdapter("setError1")
fun TextInputLayout.setError1(screenState: ScreenState?) {
    error = when (screenState) {
        ScreenState.ERROR_LOGIN -> context.getString(R.string.wrong_login)
        else -> ""
    }
}

@BindingAdapter("setError2")
fun TextInputLayout.setError2(screenState: ScreenState?) {
    error = when (screenState) {
        ScreenState.ERROR_PASSWORD -> context.getString(R.string.wrong_password)
        else -> ""
    }
}