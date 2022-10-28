package com.onix.internship.data.mapper

import com.onix.internship.entity.UserInfo
import com.onix.internship.entity.network.ApiUserInfo

class UserMapper {
    fun map(apiUserInfo: ApiUserInfo): UserInfo{
        return UserInfo(
            apiUserInfo.age ?: 0,
            apiUserInfo.count ?: 0,
            apiUserInfo.name ?: ""
        )
    }
}