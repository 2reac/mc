package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.cameraButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraInt = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(cameraInt);
            }
        });
        findViewById(R.id.wifiButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wifiInt = new Intent(MainActivity.this, WifiActivity.class);
                startActivity(wifiInt);
            }
        });

        findViewById(R.id.mapsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapsInt = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(mapsInt);
            }
        });

        findViewById(R.id.meterButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent meterInt = new Intent(MainActivity.this, MeterActivity.class);
                startActivity(meterInt);
            }
        });

        findViewById(R.id.messageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent messageInt = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(messageInt);
            }
        });

        findViewById(R.id.serviceButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uploadInt = new Intent(MainActivity.this, WebActivity.class);
                startActivity(uploadInt);
            }
        });
    }
}
