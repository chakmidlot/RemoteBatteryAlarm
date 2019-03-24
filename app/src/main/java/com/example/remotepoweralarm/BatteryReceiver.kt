package com.example.remotepoweralarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log
import android.widget.Toast
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset
import javax.net.ssl.HttpsURLConnection

class SendBattery(val level: String) : Thread(){
  override fun run() {
      val url = URL("http://chakmidlot.net:4000/?battery=$level")
      val conn = url.openConnection() as HttpURLConnection
      if(conn.responseCode == HttpsURLConnection.HTTP_OK){
          conn.disconnect()
      }
  }
}

class BatteryReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("battery", intent.action)
        val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        val batteryPct = level / scale.toFloat()

        Log.d("battery", batteryPct.toString())
        SendBattery(batteryPct.toString()).start()

    }
}
