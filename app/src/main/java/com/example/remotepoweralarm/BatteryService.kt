package com.example.remotepoweralarm

import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.IBinder
import android.util.Log
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection


class BatteryService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        Log.i("app", intent.toString())
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        Log.i("app", "onStart")

        if (intent != null) {
            val level = getLevel(intent)

            if (level == 40) {
                SendBattery(level.toString()).start()
            }
        }
        return START_STICKY
    }

    private fun getLevel(intent: Intent): Int {
        val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        return (level / scale.toFloat() * 100).toInt()
    }

}
