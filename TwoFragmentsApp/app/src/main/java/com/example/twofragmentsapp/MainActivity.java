package com.example.twofragmentsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button xbtn1;
    Button xbtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xbtn1 = findViewById(R.id.btn1);
        xbtn2 = findViewById(R.id.btn2);

        xbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fr = getSupportFragmentManager();
                FragmentTransaction ft = fr.beginTransaction();
                fragment1 obj = new fragment1();
                ft.replace(R.id.main,obj);
                ft.commit();
            }
        });

        xbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fr = getSupportFragmentManager();
                FragmentTransaction ft = fr.beginTransaction();
                fragment2 obj = new fragment2();
                ft.replace(R.id.main,obj);
                ft.commit();
            }
        });
    }
}
