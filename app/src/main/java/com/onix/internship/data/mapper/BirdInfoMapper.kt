package com.onix.internship.data.mapper

import com.onix.internship.entity.BirdInfo
import com.onix.internship.entity.network.ApiBirdInfo

class BirdInfoMapper(private val songInfoMapper: SongInfoMapper) {
    fun map(apiBirdInfo: ApiBirdInfo): BirdInfo {
        return BirdInfo(
            id = apiBirdInfo.id,
            gen = apiBirdInfo.gen ?: "",
            sp = apiBirdInfo.sp ?: "",
            ssp = apiBirdInfo.ssp ?: "",
            en = apiBirdInfo.en ?: "",
            rec = apiBirdInfo.rec ?: "",
            cnt = apiBirdInfo.cnt ?: "",
            loc = apiBirdInfo.loc ?: "",
            lat = apiBirdInfo.lat ?: "",
            lng = apiBirdInfo.lng ?: "",
            alt = apiBirdInfo.alt ?: "",
            type = apiBirdInfo.type ?: "",
            url = apiBirdInfo.url ?: "",
            file = apiBirdInfo.file ?: "",
            file_name = apiBirdInfo.file_name ?: "",
            sono = songInfoMapper.map(apiBirdInfo.sono),
            lic = apiBirdInfo.lic ?: "",
            q = apiBirdInfo.q ?: "",
            length = apiBirdInfo.length ?: "",
            time = apiBirdInfo.time ?: "",
            date = apiBirdInfo.date ?: "",
            uploaded = apiBirdInfo.uploaded ?: "",
            also = apiBirdInfo.also ?: listOf(),
            rmk = apiBirdInfo.rmk ?: "",
            bird_seen = apiBirdInfo.bird_seen ?: "",
            playback_used = apiBirdInfo.playback_used ?: ""
        )
    }
}