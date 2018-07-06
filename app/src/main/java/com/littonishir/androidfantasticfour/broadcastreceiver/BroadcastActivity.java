package com.littonishir.androidfantasticfour.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.littonishir.androidfantasticfour.R;

public class BroadcastActivity extends AppCompatActivity implements View.OnClickListener {

    private DynamicBroadcastReceiver dynamicBroadcastReceiver;
    private TextView tv_static;
    private TextView tv_dynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        tv_static = findViewById(R.id.tv_static);
        tv_dynamic = findViewById(R.id.tv_dynamic);
        tv_static.setOnClickListener(this);
        tv_dynamic.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_static:
                Intent intent = new Intent();
                intent.setAction("ishir");
                intent.putExtra("info", "ishir");
                sendBroadcast(intent);
                break;
            case R.id.tv_dynamic:
                Intent dynamic_intent = new Intent();
                dynamic_intent.setAction("com.littonishir");
                dynamic_intent.putExtra("info", "ishir");
                sendBroadcast(dynamic_intent);
                break;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        // 1. 实例化BroadcastReceiver子类
        dynamicBroadcastReceiver = new DynamicBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        // 2. 设置接收广播的类型
        intentFilter.addAction("com.littonishir");
        // 3. 动态注册：调用Context的registerReceiver()方法
        registerReceiver(dynamicBroadcastReceiver, intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(dynamicBroadcastReceiver);
    }
}
