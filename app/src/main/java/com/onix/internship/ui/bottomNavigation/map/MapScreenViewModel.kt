package com.onix.internship.ui.bottomNavigation.map

import android.icu.util.Calendar
import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.point.PointItem
import com.onix.internship.data.point.PointsList
import com.onix.internship.data.repository.AppSharedPreferences
import com.onix.internship.data.role.UserRole

class MapScreenViewModel(
    private val sharedPreferences: AppSharedPreferences,
    private val pointsList: PointsList
) : BaseViewModel() {

    private val _mapPoints = MutableLiveData<List<PointItem>>()
    val mapPoints: LiveData<List<PointItem>> = _mapPoints

    private val _exportPosition = SingleLiveEvent<Boolean>()
    val exportPosition: LiveData<Boolean> = _exportPosition

    fun exportMyPosition() {
        _exportPosition.value = true
    }

    fun updateMapsPoints() {
        _mapPoints.value = pointsList.getPointsList()
    }

    fun createPoint(location: Location): PointItem {
        val cal: Calendar = Calendar.getInstance()
        return PointItem(
            LatLng(
                location.latitude,
                location.longitude
            ),
            cal.timeInMillis, stringToEnum(), sharedPreferences.getIntFromSharPref()
        )
    }

    fun createMapsPoint(map: GoogleMap, location: LatLng, pointItem: PointItem, bitmap: BitmapDescriptor) {
        map.addMarker(
            MarkerOptions()
                .position(location)
                .icon(bitmap)
                .title("${pointItem.role} ${pointItem.level}")
        )
    }

    private fun stringToEnum(): UserRole {
        var role = UserRole.SLACKER
        when (sharedPreferences.getStringFromSharPref()) {
            UserRole.PLAYER.toString() -> {
                role = UserRole.PLAYER
            }
            UserRole.HERO.toString() -> {
                role = UserRole.HERO
            }
            UserRole.MASTER.toString() -> {
                role = UserRole.MASTER
            }
        }
        return role
    }

    fun showUserLocation(mMap: GoogleMap, location: Location) {
        mMap.moveCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(
                    location.latitude,
                    location.longitude
                ), 15f
            )
        )
    }
}