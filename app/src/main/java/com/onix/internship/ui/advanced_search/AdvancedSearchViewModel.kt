package com.onix.internship.ui.advanced_search

import androidx.lifecycle.LiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.ui.search.SearchModel

class AdvancedSearchViewModel : BaseViewModel() {
    private val _goToResult = SingleLiveEvent<String>()
    val goToResult: LiveData<String> = _goToResult

    val model = SearchModel()

    fun startSearching() {
        _goToResult.value = createQuery()
    }

    private fun createQuery(): String {
        var query = ""
        model.apply {
            if (gen.get() != null) { query += "gen:\"${gen.get()}\"" }
            if (ssp.get() != null) { query += "ssp:\"${ssp.get()}\"" }
            if (also.get() != null) { query += "also:\"$also.get\"" }
            if (type.get() != null) { query += "type:\"$type.get\"" }
            if (loc.get() != null) { query += "loc:\"$loc.get\"" }
            if (cnt.get() != "CHOOSE") { query += "cnt:\"${cnt.get()}\"" }
            if (rmk.get() != null) { query += "rmk:\"$rmk.get\"" }
            if (rec.get() != null) { query += "rec:\"$rec.get\"" }
        }
        return query
    }
}