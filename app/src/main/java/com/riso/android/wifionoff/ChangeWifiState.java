package com.riso.android.wifionoff;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

/**
 * Created by richard.janitor on 26-Nov-18.
 */

public class ChangeWifiState extends BroadcastReceiver {
    WifiManager wfm;

    @Override
    public void onReceive(Context context, Intent intent) {
        wfm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        wfm.setWifiEnabled(Boolean.parseBoolean(intent.getStringExtra("wifi")));
        Toast.makeText(context, "Received", Toast.LENGTH_SHORT).show();
    }
}
