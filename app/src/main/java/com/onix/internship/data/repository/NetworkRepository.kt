package com.onix.internship.data.repository

import com.onix.internship.arch.network.Either
import com.onix.internship.data.mapper.UserMapper
import com.onix.internship.entity.UserInfo
import com.onix.internship.network.NetworkService

class NetworkRepository(
    private val networkService: NetworkService,
    private val userMapper: UserMapper
) {
    suspend fun getMem(name: String): Either<UserInfo> {
        return try {
            val response = networkService.getUser(name)
            val body = response.body()
            if (!response.isSuccessful || body == null) {
                Either.failure(Throwable("Request error"))
            } else {
                Either.success(userMapper.map(body))
            }
        } catch (e: Error) {
            Either.failure(e)
        }
    }
}