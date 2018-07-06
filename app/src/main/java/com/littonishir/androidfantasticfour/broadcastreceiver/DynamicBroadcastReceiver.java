package com.littonishir.androidfantasticfour.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by littonishir on 2018/7/5.
 */
public class DynamicBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String info = intent.getStringExtra("info");
        Toast.makeText(context, info + " 我接收到动态注册的广播了----来自Java的输出", Toast.LENGTH_SHORT).show();
    }
}
