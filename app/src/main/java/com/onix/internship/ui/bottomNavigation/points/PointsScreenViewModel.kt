package com.onix.internship.ui.bottomNavigation.points

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.data.PointItem
import com.onix.internship.data.repository.Test

class PointsScreenViewModel(test: Test) : BaseViewModel() {
    private val _pointsLiveData = MutableLiveData(test.getTest())
    val pointsLiveData: LiveData<List<PointItem>> = _pointsLiveData
}