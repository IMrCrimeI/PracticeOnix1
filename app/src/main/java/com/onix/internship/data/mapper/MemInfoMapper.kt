package com.onix.internship.data.mapper

import com.onix.internship.entity.MemInfo
import com.onix.internship.entity.network.ApiMemInfo

class MemInfoMapper {

    fun map(apiMemInfo: ApiMemInfo): MemInfo {
        return MemInfo(
            id = apiMemInfo.ID?.toInt() ?: 0,
            bottomText = apiMemInfo.bottomText ?: "",
            image = apiMemInfo.image ?: "",
            name = apiMemInfo.name ?: "",
            tags = apiMemInfo.tags ?: "",
            topText = apiMemInfo.topText ?: ""
        )
    }
}