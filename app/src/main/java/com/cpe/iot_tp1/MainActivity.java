package com.cpe.iot_tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.bouton1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.setText("Ah batard tu cliques ?");
            }
        });
    }

    private SensorManager sm;
    public float min_acc;
    protected void onResume() {
        super.onResume();
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_UI);
    }

    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
        sm = null;
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    public void onSensorChanged(SensorEvent event) {
        TextView text_1 = findViewById(R.id.disp1);
        TextView text_2 = findViewById(R.id.disp2);
        TextView text_3 = findViewById(R.id.disp3);
        text_1.setText(String.valueOf(event.values[0]));
        text_2.setText(String.valueOf(event.values[1]));
        text_3.setText(String.valueOf(event.values[2]));
    }
}