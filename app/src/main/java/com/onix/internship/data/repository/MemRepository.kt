package com.onix.internship.data.repository

import com.onix.internship.arch.network.Either
import com.onix.internship.data.mapper.MemPageInfoMapper
import com.onix.internship.entity.MemInfo
import com.onix.internship.network.NetworkService

class MemRepository(
    private val networkService: NetworkService,
    private val memPageInfoMapper: MemPageInfoMapper
) {
    suspend fun getMem(page: Int): Either<List<MemInfo>> {
        return try {
            val response = networkService.getMeme(page)
            val body = response.body()

            if (!response.isSuccessful || body == null) {
                Either.failure(Throwable("Request error"))
            } else {
                Either.success(memPageInfoMapper.map(body).data)
            }
        } catch (e: Error) {
            Either.failure(e)
        }
    }
}