package com.example.remotepoweralarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent


object Scheduler {
    fun scheduleBatteryCheck(context: Context) {
        val dialogIntent = Intent(context, BatteryReceiver::class.java)

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val pendingIntent = PendingIntent.getBroadcast(context, 0, dialogIntent, PendingIntent.FLAG_CANCEL_CURRENT)

        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),   30 * 60 * 1000, pendingIntent)
    }
}
