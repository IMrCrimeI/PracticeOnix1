package com.onix.internship.json

import com.google.android.gms.maps.model.LatLng
import com.onix.internship.data.point.PointItem
import com.onix.internship.data.role.UserRole
import org.json.JSONObject
import org.json.JSONTokener

class JsonFormatter {

    fun jsonToPointItem(json: String): PointItem {
        val jsonObject = JSONTokener(json).nextValue() as JSONObject

        val latLong = LatLng(jsonObject.getDouble(LAT), jsonObject.getDouble(LON))

        return PointItem(
            latLong,
            jsonObject.getLong(CALENDAR),
            stringToEnum(jsonObject.getString(ROLE)),
            jsonObject.getInt(LEVEL)
        )
    }

    fun pointItemToJson(point: PointItem): String {
        val jsonObject = JSONObject()

        jsonObject.put(LAT, point.location.latitude)
        jsonObject.put(LON, point.location.longitude)
        jsonObject.put(CALENDAR, point.calendar)
        jsonObject.put(ROLE, point.role.toString())
        jsonObject.put(LEVEL, point.level)

        return jsonObject.toString()
    }

    private fun stringToEnum(jsonRole: String): UserRole {
        var role = UserRole.SLACKER
        when (jsonRole) {
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

    companion object {
        const val LAT = "lat"
        const val LON = "lon"
        const val CALENDAR = "calendar"
        const val ROLE = "role"
        const val LEVEL = "level"
    }
}