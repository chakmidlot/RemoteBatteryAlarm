package com.example.remotepoweralarm.notification

interface BaseNotification {
    fun sendLevel(deviceId: String, level: Int)
}
