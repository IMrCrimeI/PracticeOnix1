package com.onix.internship.network

import com.onix.internship.entity.network.ApiPageInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET("https://www.xeno-canto.org/api/2/recordings")
    suspend fun getResultOfSearch(@Query("query")query : String): Response<ApiPageInfo>
}