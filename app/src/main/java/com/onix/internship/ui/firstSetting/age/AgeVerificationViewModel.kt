package com.onix.internship.ui.firstSetting.age

import androidx.lifecycle.LiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.repository.AppSharedPreferences

class AgeVerificationViewModel(private val sharedPreferences: AppSharedPreferences) : BaseViewModel() {
    private val _moveToFragment = SingleLiveEvent<Boolean>()
    val moveToFragment: LiveData<Boolean> = _moveToFragment

    val model = AgeVerificationModel()

    fun goToSkillFragment() {
        _moveToFragment.value = model.age.get()
        sharedPreferences.setBooleanInSharPref(model.age.get())
    }
}