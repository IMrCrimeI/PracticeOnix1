package com.onix.internship.ui.emergency

import androidx.lifecycle.LiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent

class EmergencyFragmentViewModel : BaseViewModel() {
    private val _moveToDialog = SingleLiveEvent<Unit>()
    val moveToDialog: LiveData<Unit> = _moveToDialog

    fun clearDatabase() {
        _moveToDialog.value = Unit
    }
}