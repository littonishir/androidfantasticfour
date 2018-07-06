package com.littonishir.androidfantasticfour.kotlinversion.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.littonishir.androidfantasticfour.R
import kotlinx.android.synthetic.main.activity_broad_cast_kt.*

class BroadCastKtActivity : AppCompatActivity(), View.OnClickListener {
    private var dynamicBroadcastKtReceiver: DynamicBroadcastKtReceiver? = null

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_static_kt -> {
                val intent = Intent()
                intent.action = "ishirkt"
                intent.putExtra("info", "ishir")
                sendBroadcast(intent)
            }
            R.id.tv_dynamic_kt -> {
                val intent = Intent()
                intent.action = "com.littonishir"
                intent.putExtra("info", "ishir")
                sendBroadcast(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broad_cast_kt)
        tv_static_kt.setOnClickListener(this)
        tv_dynamic_kt.setOnClickListener(this)

    }

    override fun onResume() {
        super.onResume()
        // 1. 实例化BroadcastReceiver子类
        dynamicBroadcastKtReceiver = DynamicBroadcastKtReceiver()
        val intentFilter = IntentFilter()
        // 2. 设置接收广播的类型
        intentFilter.addAction("com.littonishir")
        // 3. 动态注册：调用Context的registerReceiver()方法
        registerReceiver(dynamicBroadcastKtReceiver, intentFilter)

    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(dynamicBroadcastKtReceiver)
    }

}
