package com.onix.internship.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkFactory {

    fun <S> createService(protocol: Class<S>): S {
        return retrofit.create(protocol)
    }


    private val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    private val okHttpClient: OkHttpClient
        get() = OkHttpClient
            .Builder()
            .build()

    companion object {
        const val BASE_URL = "https://api.agify.io"
    }
}