package com.example.remotepoweralarm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.remotepoweralarm.scheduler.ExactScheduler


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ExactScheduler.scheduleBatteryCheck(this)
    }
}
