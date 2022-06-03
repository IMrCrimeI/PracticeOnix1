package com.onix.internship.practiceonixtask.ui.login

import androidx.databinding.ObservableField
import com.onix.internship.practiceonixtask.ScreenState

data class LoginModel(private val _login: String = "", private val _password: String = "") {
    val login = ObservableField(_login)
    val password = ObservableField(_login)

    fun validate(): ScreenState {
        return if (login.get() != ADMIN_LOGIN) {
            ScreenState.ERROR_LOGIN
        } else return if (password.get() != ADMIN_PASSWORD) {
            ScreenState.ERROR_PASSWORD
        } else ScreenState.SUCCESS
    }

    companion object {
        const val ADMIN_LOGIN = "Nikolas"
        const val ADMIN_PASSWORD = "kbcbq,e,jy"
    }
}
