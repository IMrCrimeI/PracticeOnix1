package com.onix.internship.data.point

import com.google.android.gms.maps.model.LatLng
import com.onix.internship.data.role.UserRole

data class PointItem(
    val location: LatLng,
    val calendar: Long,
    val role: UserRole,
    val level: Int
)
