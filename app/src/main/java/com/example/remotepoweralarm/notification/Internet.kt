package com.example.remotepoweralarm.notification

import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class Internet : BaseNotification{
    override fun sendLevel(level: Int) {
        Sender(level.toString()).start()
    }
}

class Sender(private val level: String) : Thread(){
    override fun run() {
        val url = URL("http://chakmidlot.net:4000/?battery=$level")
        val conn = url.openConnection() as HttpURLConnection
        if(conn.responseCode == HttpsURLConnection.HTTP_OK){
            conn.disconnect()
        }
    }
}
