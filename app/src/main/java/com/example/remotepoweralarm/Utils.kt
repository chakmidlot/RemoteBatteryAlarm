package com.example.remotepoweralarm

import android.util.Base64
import kotlin.random.Random

fun generateDeviceId(): String {
    val rnd = Random
    return Base64.encodeToString(rnd.nextBytes(64), Base64.NO_WRAP + Base64.NO_PADDING + Base64.URL_SAFE)
}
