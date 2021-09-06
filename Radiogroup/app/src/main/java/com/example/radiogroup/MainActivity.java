package com.example.radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView tv = findViewById(R.id.name);
        String s_name = tv.getText().toString();
        RadioGroup colors = (RadioGroup)findViewById(R.id.color);
        int colorID = colors.getCheckedRadioButtonId();
        String s_color = ((RadioButton)findViewById(colorID)).getText().toString();

        Intent I = new Intent(this,Next.class);
        I.putExtra("color",s_color);
        I.putExtra("name",s_name);
        startActivity(I);
    }
}
