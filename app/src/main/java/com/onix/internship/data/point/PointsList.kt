package com.onix.internship.data.point

class PointsList {
    private val points = mutableListOf<PointItem>()

    fun getPointsList(): List<PointItem> {
        return points.toList()
    }

    fun addPointInPointsList(item: PointItem) {
        points.add(item)
    }

    fun removePointFromPointsList(item: PointItem) {
        points.remove(item)
    }
}