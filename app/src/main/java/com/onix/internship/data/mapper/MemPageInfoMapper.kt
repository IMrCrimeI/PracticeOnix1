package com.onix.internship.data.mapper

import com.onix.internship.entity.MemPageInfo
import com.onix.internship.entity.network.ApiMemPageInfo

class MemPageInfoMapper(private val memInfoMapper: MemInfoMapper) {
    fun map(apiMemPageInfo: ApiMemPageInfo): MemPageInfo {
        return MemPageInfo(
            code = apiMemPageInfo.code?.toInt() ?: 0,
            data = apiMemPageInfo.data?.map { memInfoMapper.map(it) } ?: listOf(),
            message = apiMemPageInfo.message ?: "",
            next = apiMemPageInfo.next ?: ""
        )
    }
}