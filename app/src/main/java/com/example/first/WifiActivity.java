package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WifiActivity extends AppCompatActivity {

    private WifiManager wifiManager;
    TextView wfStatus;
    Button wfCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        wfStatus = findViewById(R.id.connView);
        wfCheck = findViewById(R.id.checkBtn);

        wfCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConnection();
            }
        });
    }

    private void checkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeInfo = connectivityManager.getActiveNetworkInfo();
        if( (activeInfo != null && activeInfo.isConnected()) && (activeInfo.getType() == ConnectivityManager.TYPE_WIFI) ) {
            wfStatus.setText("ON");
        } else {
            wfStatus.setText("OFF");
        }
    }

    public void enableWiFi(View v) {
        wifiManager.setWifiEnabled(true);
    }
    public void disableWiFi(View v) {
        wifiManager.setWifiEnabled(false);
    }
}
