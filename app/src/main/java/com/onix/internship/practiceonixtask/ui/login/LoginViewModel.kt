package com.onix.internship.practiceonixtask.ui.login

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onix.internship.practiceonixtask.ScreenState

class LoginViewModel : ViewModel() {
    private val _screenState = MutableLiveData<ScreenState>()
    val screenState: LiveData<ScreenState> = _screenState

    fun checkLogin(login: String, password: String) {

        if (login.isBlank() || login != ADMIN_LOGIN) {
            _screenState.value = ScreenState.ERROR_LOGIN
        } else if (password.isBlank() || password != ADMIN_PASSWORD) {
            _screenState.value = ScreenState.ERROR_PASSWORD
        } else _screenState.value = ScreenState.SUCCESS

    }

    fun clearLogin( ) {
        _screenState.value = ScreenState.IDLE
    }


    companion object {
        const val ADMIN_LOGIN = "Nikolas"
        const val ADMIN_PASSWORD = "kbcbq,e,jy"
    }
}