package com.example.remotepoweralarm.scheduler

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.example.remotepoweralarm.BatteryReceiver


object ExactScheduler {
    val repeatingTime = 30 * 60 * 1000

    fun scheduleBatteryCheck(context: Context) {
        val batteryIntent = Intent(context, BatteryReceiver::class.java)

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val pendingIntent = PendingIntent.getBroadcast(context, 0, batteryIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + repeatingTime, pendingIntent)
    }
}
