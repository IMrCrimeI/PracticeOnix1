package com.onix.internship.data.mapper

import com.onix.internship.entity.PageInfo
import com.onix.internship.entity.network.ApiPageInfo

class PageInfoMapper(private val birdInfoMapper: BirdInfoMapper) {
    fun map(apiPageInfo: ApiPageInfo): PageInfo {
        return PageInfo(
            numRecording = apiPageInfo.numRecording,
            numSpecies = apiPageInfo.numSpecies,
            page = apiPageInfo.page,
            numPages = apiPageInfo.numPages,
            recordings = apiPageInfo.recordings.map { birdInfoMapper.map(it) }
        )
    }
}