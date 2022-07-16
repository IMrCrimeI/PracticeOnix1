package com.onix.internship.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.data.TabStates
import com.onix.internship.data.AppSettings

class MainViewModel(val appSettings: AppSettings) : BaseViewModel() {

    private val _goToHome = MutableLiveData(TabStates.NOTHING)
    val goToHome: LiveData<TabStates> = _goToHome

    fun goToHomeTab() {
        _goToHome.value = TabStates.HOME
    }

    fun goToDocumentTab() {
        _goToHome.value = TabStates.DOCUMENT
    }

    fun addNewTask() {
        _goToHome.value = TabStates.ADD_TASK
    }

    fun goToActivityTab() {
        _goToHome.value = TabStates.ACTIVITY
    }

    fun goToFolderTab() {
        _goToHome.value = TabStates.FOLDER
    }
}