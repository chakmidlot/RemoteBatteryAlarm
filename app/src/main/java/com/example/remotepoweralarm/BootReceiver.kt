package com.example.remotepoweralarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import android.os.BatteryManager



class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        context.applicationContext.registerReceiver(BatteryReceiver(), IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }
}
