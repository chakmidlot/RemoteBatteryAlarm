package com.example.remotepoweralarm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Scheduler.scheduleBatteryCheck(this)
    }
}
