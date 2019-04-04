package com.example.remotepoweralarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.content.Context.BATTERY_SERVICE
import com.example.remotepoweralarm.notification.Internet
import com.example.remotepoweralarm.scheduler.ExactScheduler


class BatteryReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        ExactScheduler.scheduleBatteryCheck(context)

        val settings = context.getSharedPreferences("settings", Context.MODE_PRIVATE)

        val deviceId: String
        if(settings.contains("device_id")) {
            deviceId = settings.getString("device_id", "").orEmpty()
        } else {
            deviceId = generateDeviceId()
            val editor = settings.edit()
            editor.putString("device_id", deviceId)
            editor.apply()
        }

        val bm = context.getSystemService(BATTERY_SERVICE) as BatteryManager?
        if (bm != null) {
            val level = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
            Internet().sendLevel(deviceId, level)
        }
    }

}
