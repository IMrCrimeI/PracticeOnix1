package com.onix.internship.practiceonixtask.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onix.internship.practiceonixtask.ScreenState

class LoginViewModel : ViewModel() {
    private val _screenState = MutableLiveData<ScreenState>()
    val screenState: LiveData<ScreenState> = _screenState
    val model = LoginModel()

    fun checkLogin() {
        _screenState.value = model.validate()
    }

    fun clearLogin() {
        _screenState.value = ScreenState.IDLE
    }

}