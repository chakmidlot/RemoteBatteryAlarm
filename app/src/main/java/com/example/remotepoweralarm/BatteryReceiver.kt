package com.example.remotepoweralarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import android.content.Context.BATTERY_SERVICE


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
        val bm = context.getSystemService(BATTERY_SERVICE) as BatteryManager?
        if (bm != null) {
            val level = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
            SendBattery(level.toString()).start()
        }
    }

}
