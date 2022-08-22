package com.onix.internship.data.repository

import com.onix.internship.arch.network.Either
import com.onix.internship.data.mapper.PageInfoMapper
import com.onix.internship.entity.BirdInfo
import com.onix.internship.network.NetworkService

class BirdRepository(
    private val networkService: NetworkService,
    private val pageInfoMapper: PageInfoMapper
) {
    suspend fun getBird(query: String): Either<List<BirdInfo>> {
        return try {
            val response = networkService.getResultOfSearch(query)
            val body = response.body()

            if (!response.isSuccessful || body == null) {
                Either.failure(Throwable("Request error"))
            } else {
                Either.success(pageInfoMapper.map(body).recordings)
            }
        } catch (e: Error) {
            Either.failure(e)
        }
    }
}