package com.riso.android.wifionoff;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WifiActivity extends AppCompatActivity {
    ImageView wifi;
    TextView wifiOn;
    TextView wifiOff;
    WifiManager wfm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        wifi = findViewById(R.id.wifiIcon);
        wifiOn = findViewById(R.id.wifiOn);
        wifiOff = findViewById(R.id.wifiOff);


        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wfm.isWifiEnabled()) {
                    wifiOnOff(false);
                    wifiOff.setVisibility(View.VISIBLE);
                    wifiOn.setVisibility(View.INVISIBLE);
                    wifi.setColorFilter(ContextCompat.getColor(v.getContext(), R.color.black), android.graphics.PorterDuff.Mode.SRC_IN);
                } else {
                    wifiOnOff(true);
                    wifiOff.setVisibility(View.INVISIBLE);
                    wifiOn.setVisibility(View.VISIBLE);
                    wifi.setColorFilter(ContextCompat.getColor(v.getContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
                }
            }
        });


    }

    void wifiOnOff(boolean onOff){
        try {
            wfm.setWifiEnabled(onOff);
        } catch (Exception e) {
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        wfm = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wfm.isWifiEnabled()){
            wifiOff.setVisibility(View.INVISIBLE);
            wifiOn.setVisibility(View.VISIBLE);
            wifi.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);

        } else {
            wifiOff.setVisibility(View.VISIBLE);
            wifiOn.setVisibility(View.INVISIBLE);
            wifi.setColorFilter(ContextCompat.getColor(this, R.color.black), android.graphics.PorterDuff.Mode.SRC_IN);
        }
    }
}
