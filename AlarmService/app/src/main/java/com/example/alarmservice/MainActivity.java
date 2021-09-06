package com.example.alarmservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private PendingIntent pi;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.btnstart);
        Button stop = findViewById(R.id.btnstop);

        et = (EditText)findViewById(R.id.input);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = et.getText().toString();
                int x = Integer.parseInt(str);
                Intent myIntent = new Intent(MainActivity.this, Second.class);

                pi = PendingIntent.getService(MainActivity.this, 0, myIntent, 0);

                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(Calendar.SECOND, x);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);

                Toast.makeText(MainActivity.this, "Alarm will start in entered seconds...", Toast.LENGTH_LONG).show();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.cancel(pi);
                Toast.makeText(MainActivity.this, "Alarm Cancelled !!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
