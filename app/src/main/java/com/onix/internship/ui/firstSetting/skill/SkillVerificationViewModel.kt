package com.onix.internship.ui.firstSetting.skill

import androidx.lifecycle.LiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent

class SkillVerificationViewModel : BaseViewModel() {
    private val _moveToFragment = SingleLiveEvent<Boolean>()
    val moveToFragment: LiveData<Boolean> = _moveToFragment

    fun goBack() {
        _moveToFragment.value = false
    }

    fun goToRoleFragment() {
        _moveToFragment.value = true
    }
}