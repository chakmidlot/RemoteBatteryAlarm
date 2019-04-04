package com.example.remotepoweralarm.scheduler

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.example.remotepoweralarm.BatteryReceiver


object InexactScheduler {
    fun scheduleBatteryCheck(context: Context) {
        val dialogIntent = Intent(context, BatteryReceiver::class.java)

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val pendingIntent = PendingIntent.getBroadcast(context, 0, dialogIntent, PendingIntent.FLAG_CANCEL_CURRENT)

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),    60 * 1000, pendingIntent)
    }
}
