package com.example.remotepoweralarm

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.registerReceiver(BatteryReceiver(), IntentFilter(Intent.ACTION_BATTERY_CHANGED))

    }
}
