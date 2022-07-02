package com.onix.internship.data

class TranslationStorage {
    private var dictionary = listOf<DictionaryItem>()
    private var searchingResults = mutableListOf<DictionaryItem>()
    private var searchingHistory = mutableListOf<DictionaryItem>()

    var choice = false

    fun saveDictionary(list: List<DictionaryItem>) {
        dictionary = list
    }

    fun getDictionary(): List<DictionaryItem> {
        return dictionary
    }

    fun saveSearchingResults(item: DictionaryItem) {
        searchingResults.add(item)
    }

    fun getSearchingResults(): List<DictionaryItem> {
        return searchingResults
    }

    fun getSearchingHistory(): List<DictionaryItem> {
        if (searchingHistory.size == MAX_HISTORY_SIZE) {
            searchingHistory.removeFirst()
        }
        searchingResults.firstOrNull()?.let {
            if (searchingHistory.contains(searchingResults.first())) {
                searchingHistory.remove(it)
                searchingHistory.add(it)
            } else {
                searchingHistory.add(it)
            }
        }
        return searchingHistory
    }

    fun clearResults() {
        searchingResults.clear()
    }

    companion object {
        const val MAX_HISTORY_SIZE = 16
    }
}
