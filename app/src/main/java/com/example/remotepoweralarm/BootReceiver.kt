package com.example.remotepoweralarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.remotepoweralarm.scheduler.ExactScheduler


class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        ExactScheduler.scheduleBatteryCheck(context.applicationContext)
    }
}
