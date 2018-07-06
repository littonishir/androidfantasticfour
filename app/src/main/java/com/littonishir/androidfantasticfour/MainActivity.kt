package com.littonishir.androidfantasticfour

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.littonishir.androidfantasticfour.broadcastreceiver.BroadcastActivity
import com.littonishir.androidfantasticfour.kotlinversion.broadcastreceiver.BroadCastKtActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_java ->
                startActivity(intent.setClass(this, BroadcastActivity::class.java))

            R.id.tv_kotlin ->
                startActivity(intent.setClass(this, BroadCastKtActivity::class.java))


        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_java.setOnClickListener(this)
        tv_kotlin.setOnClickListener(this)
    }
}
