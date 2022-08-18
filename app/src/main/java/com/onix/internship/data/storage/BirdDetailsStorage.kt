package com.onix.internship.data.storage

import com.onix.internship.entity.BirdInfo

class BirdDetailsStorage {
    private val birdDetails = mutableListOf<BirdInfo>()

    fun saveBirdDetails(birdInfo: BirdInfo) {
        birdDetails.add(birdInfo)
    }

    fun getBirdDetails(): BirdInfo {
        return birdDetails.last()
    }

    fun clearBirdDetails() {
        birdDetails.clear()
    }
}