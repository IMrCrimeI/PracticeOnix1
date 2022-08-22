package com.onix.internship.data.mapper

import com.onix.internship.entity.SongInfo
import com.onix.internship.entity.network.ApiSongInfo

class SongInfoMapper {
    fun map(apiSongInfo: ApiSongInfo?): SongInfo {
        return if (apiSongInfo == null) {
            SongInfo(
                small = "",
                med = "",
                large = "",
                full = ""
            )
        } else {
            SongInfo(
                small = apiSongInfo.small,
                med = apiSongInfo.med,
                large = apiSongInfo.large,
                full = apiSongInfo.full
            )
        }
    }
}