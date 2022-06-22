package com.onix.internship.ui.wifi

import android.content.Context
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager

class WifiScanner(context: Context) {

    private val wifiManager =
        context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

    init {
        wifiManager.startScan()
    }

    fun getWifiResult(): List<ScanResult> {
        return wifiManager.scanResults.take(MAX_LIST_SIZE)
    }

    companion object {
        const val MAX_LIST_SIZE = 16
    }
}