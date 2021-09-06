package com.example.radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Next extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        String s_color = getIntent().getStringExtra("color");
        String s_name = getIntent().getStringExtra("name");
        TextView headtv = findViewById(R.id.head);
        TextView texttv = findViewById(R.id.text);
        headtv.setText("Wow ! "+s_name+" ,You have a great choice..");
        texttv.setText("Your favourite color is "+s_color);
    }
}
