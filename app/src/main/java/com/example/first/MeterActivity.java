package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class MeterActivity extends AppCompatActivity implements SensorEventListener{

    private TextView xText, yText, zText;
    private Sensor sensor;
    private SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meter);

        // create sensor manager
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        // accelerometer sensor
        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // register sensor listener
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        // assign text views
        xText = (TextView) findViewById(R.id.xText);
        yText = (TextView) findViewById(R.id.yText);
        zText = (TextView) findViewById(R.id.zText);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xText.setText(Float.toString(event.values[0]));
        yText.setText(Float.toString(event.values[1]));
        zText.setText(Float.toString(event.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // no use
    }
}
