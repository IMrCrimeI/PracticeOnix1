package com.onix.internship.network

import com.onix.internship.entity.network.ApiUserInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET("/")
    suspend fun getUser(@Query("name") name: String): Response<ApiUserInfo>
}