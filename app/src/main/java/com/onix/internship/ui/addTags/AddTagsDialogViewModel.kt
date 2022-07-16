package com.onix.internship.ui.addTags

import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.Repository

class AddTagsDialogViewModel(private val repository: Repository) : BaseViewModel() {
    val tags = MutableLiveData("")

    val backToFragment = SingleLiveEvent<Unit>()

    fun backToAddTask() {
        backToFragment.value = Unit
    }

    fun addTags() {
        repository.addTagsItem(tags.value.toString())
        backToFragment.value = Unit
    }
}