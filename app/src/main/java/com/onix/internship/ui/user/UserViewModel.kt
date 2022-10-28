package com.onix.internship.ui.user

import androidx.lifecycle.LiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent

class UserViewModel(val model: UserModel) : BaseViewModel() {

    private val _moveToResult = SingleLiveEvent<Unit>()
    val moveToResult: LiveData<Unit> = _moveToResult

    fun goToResult() {
        _moveToResult.value = Unit
    }
}