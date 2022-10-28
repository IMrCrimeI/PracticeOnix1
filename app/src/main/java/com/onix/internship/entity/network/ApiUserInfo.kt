package com.onix.internship.entity.network

import com.google.gson.annotations.SerializedName

data class ApiUserInfo(
    @SerializedName("age")val age: Int?,
    @SerializedName("count")val count: Int?,
    @SerializedName("name")val name: String?
)