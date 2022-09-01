package com.onix.internship.ui.mem

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.repository.MemRepository
import com.onix.internship.entity.MemInfo
import kotlinx.coroutines.flow.Flow

class MemViewModel(
    private val memRepository: MemRepository
) : BaseViewModel() {

    private val _openFilterPopup = SingleLiveEvent<Unit>()
    val openFilterPopup: LiveData<Unit> = _openFilterPopup

    val filter: ObservableField<String> = ObservableField("All")

    fun getMemList(): Flow<PagingData<MemInfo>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE, enablePlaceholders = false),
            pagingSourceFactory = { memRepository.memesPagingSource() }
        )
            .flow
            .cachedIn(viewModelScope)
    }

    fun filterData(data: PagingData<MemInfo>): PagingData<MemInfo> {
        return if (filter.get() == "All") {
            data
        } else {
            data.filter {
                val tags = it.tags.lowercase()
                val filter = filter.get()!!.lowercase()
                tags.contains(filter)
            }
        }
    }

    fun openFilterPopup() {
        _openFilterPopup.value = Unit
    }

    companion object {
        private const val ITEMS_PER_PAGE = 8
    }
}