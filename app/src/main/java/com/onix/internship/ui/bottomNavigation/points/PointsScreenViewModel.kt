package com.onix.internship.ui.bottomNavigation.points

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.point.PointItem
import com.onix.internship.data.point.PointsList

class PointsScreenViewModel(private val pointsList: PointsList) : BaseViewModel() {
    private val _pointsLiveData = MutableLiveData<List<PointItem>>()
    val pointsLiveData: LiveData<List<PointItem>> = _pointsLiveData

    private val _addPoint = SingleLiveEvent<Unit>()
    val addPoint: LiveData<Unit> = _addPoint

    fun addPoint() {
        _addPoint.value = Unit
    }

    fun addItemInRecyclerItem(pointItem: PointItem) {
        pointsList.addPointInPointsList(pointItem)
        _pointsLiveData.value = pointsList.getPointsList()
    }

    fun removeItemFromRecyclerItem(pointItem: PointItem){
        pointsList.removePointFromPointsList(pointItem)
        _pointsLiveData.value = pointsList.getPointsList()
    }
}