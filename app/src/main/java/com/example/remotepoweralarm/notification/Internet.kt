package com.example.remotepoweralarm.notification

import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class Internet : BaseNotification{
    override fun sendLevel(deviceId: String, level: Int) {
        Sender(deviceId, level.toString()).start()
    }
}

class Sender(private val deviceId: String, private val level: String) : Thread(){
    override fun run() {
        val url = URL("http://chakmidlot.net:6100/save_level?level=$level&device_id=$deviceId&charging=false")
        val conn = url.openConnection() as HttpURLConnection
        if(conn.responseCode == HttpsURLConnection.HTTP_OK){
            conn.disconnect()
        }
    }
}
