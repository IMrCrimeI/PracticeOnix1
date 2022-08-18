package com.onix.internship.data.storage

class SearchStorage {
    private val searchRequest = mutableListOf<String>()

    fun saveRequest(request: String) {
        searchRequest.add(request)
    }

    fun getRequest(): String {
        return searchRequest.last()
    }

    fun clearRequest() {
        searchRequest.clear()
    }
}