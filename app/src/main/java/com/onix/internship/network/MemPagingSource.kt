package com.onix.internship.network

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.onix.internship.arch.network.onFailure
import com.onix.internship.arch.network.onSuccess
import com.onix.internship.data.repository.NetworkRepository
import com.onix.internship.entity.MemInfo
import kotlin.math.max

private const val STARTING_KEY = 1

class MemPagingSource(
    private val network: NetworkRepository
) : PagingSource<Int, MemInfo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MemInfo> {

        val page = params.key ?: STARTING_KEY

        var data = listOf<MemInfo>()

        network.getMem(page)
            .onSuccess {
                data = it
                Log.d("DEBUG", it.toString())
            }
            .onFailure {
                Log.d("DEBUG", it.toString())
            }

        return LoadResult.Page(
            data = data,
            prevKey = if (page != STARTING_KEY) page - 1
            else null,
            nextKey = page + 1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, MemInfo>): Int? {
//        val position = state.anchorPosition ?: return null
//        val article = state.closestItemToPosition(position) ?: return null
//        return ensureValidKey(key = article.id - (state.config.pageSize / 8))
        return null
    }

    /**
     * Makes sure the paging key is never less than [STARTING_KEY]
     */
    private fun ensureValidKey(key: Int) = max(STARTING_KEY, key)
}