package com.example.testcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button b = findViewById(R.id.btn);
        b.setOnClickListener((View.OnClickListener)this);
    }

    @Override
    public void onClick(View v) {
        EditText inp = findViewById(R.id.input);
        String text = inp.getText().toString();

        View obj;
        obj = findViewById(R.id.main);

        obj.setBackgroundColor(Color.parseColor(text));
    }
}
