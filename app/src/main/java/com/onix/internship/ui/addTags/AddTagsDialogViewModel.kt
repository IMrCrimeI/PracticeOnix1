package com.onix.internship.ui.addTags

import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.Repository

class AddTagsDialogViewModel : BaseViewModel() {
    val tags = MutableLiveData<String>()

    val backToFragment = SingleLiveEvent<Boolean>()

    fun backToAddTask(it: Boolean) {
        backToFragment.value = it
    }
}