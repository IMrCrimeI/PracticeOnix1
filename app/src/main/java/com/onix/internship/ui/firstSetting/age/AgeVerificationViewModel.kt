package com.onix.internship.ui.firstSetting.age

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent

class AgeVerificationViewModel : BaseViewModel() {
    private val _moveToFragment = SingleLiveEvent<Boolean>()
    val moveToFragment: LiveData<Boolean> = _moveToFragment

    private val age = MutableLiveData(false)

    fun goToSkillFragment() {
        _moveToFragment.value = age.value
    }

    fun switchChanged(isChecked: Boolean) {
        age.value = isChecked
    }
}