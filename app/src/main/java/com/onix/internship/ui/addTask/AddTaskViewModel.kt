package com.onix.internship.ui.addTask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.AppSettings
import com.onix.internship.data.DataAndTimeStates
import com.onix.internship.data.Repository
import com.onix.internship.data.TagsItem

class AddTaskViewModel(val appSettings: AppSettings, private val repository: Repository) :
    BaseViewModel() {

    private val _goToDocumentTab = SingleLiveEvent<Unit>()
    val goToDocumentTab: SingleLiveEvent<Unit> = _goToDocumentTab

    private val _tagsLiveData = MutableLiveData(repository.getTagsItem())
    val tagsLiveData: LiveData<List<TagsItem>> = _tagsLiveData

    val openDataOrTimePicker = SingleLiveEvent<DataAndTimeStates>()
    val openAddTagsFragment = SingleLiveEvent<Unit>()
    val openPopupMenu = SingleLiveEvent<Unit>()

    fun goToDocumentTab() {
        appSettings.sale.set(false)
        _goToDocumentTab.value = Unit
    }

    fun selectDataOrTime(it: DataAndTimeStates) {
        openDataOrTimePicker.value = it
    }

    fun addTags() {
        openAddTagsFragment.value = Unit
    }

    fun updateRecyclerItem(name: String?) {
        repository.addTagsItem(name)
        _tagsLiveData.value = repository.getTagsItem()
    }

    fun openPopUpMenu() {
        openPopupMenu.value = Unit
    }
}