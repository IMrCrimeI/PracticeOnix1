package com.onix.internship.data.repository

import com.onix.internship.network.MemPagingSource

class MemRepository(
    private val network: NetworkRepository
) {
    fun memesPagingSource() = MemPagingSource(network)
}