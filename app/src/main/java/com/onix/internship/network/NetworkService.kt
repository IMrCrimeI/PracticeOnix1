package com.onix.internship.network

import com.onix.internship.entity.network.ApiMemPageInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkService {
    @GET("/{page}")
    suspend fun getResultOfSearch(@Path("page") page: Int): Response<ApiMemPageInfo>

    @GET("/localememes/{page}")
    suspend fun getMeme(@Path("page") page: Int): Response<ApiMemPageInfo>
}