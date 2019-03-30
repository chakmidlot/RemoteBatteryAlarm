package com.example.remotepoweralarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.content.Context.BATTERY_SERVICE
import com.example.remotepoweralarm.notification.Internet


class BatteryReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val bm = context.getSystemService(BATTERY_SERVICE) as BatteryManager?
        if (bm != null) {
            val level = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
            Internet().sendLevel(level)
        }
    }

}
