package com.littonishir.androidfantasticfour.kotlinversion.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Created by littonishir on 2018/7/5.
 */
class StaticBroadcastKtReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val info = intent.getStringExtra("info")
        Toast.makeText(context, "$info 我接收到静态注册的广播了----来自Kotlin的输出", Toast.LENGTH_SHORT).show()
    }
}
