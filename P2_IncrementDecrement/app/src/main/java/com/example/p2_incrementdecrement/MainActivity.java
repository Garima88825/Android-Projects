package com.example.p2_incrementdecrement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int number;
    TextView n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n=(TextView)findViewById(R.id.num);
        number=Integer.parseInt(n.getText().toString());
    }

    public void incrementNum(View v){
        number++;
        n.setText(Integer.toString(number));
    }

    public void decrementNum(View v){
        number--;
        n.setText(Integer.toString(number));
    }

    public void resetNum(View v){
        number=0;
        n.setText(Integer.toString(number));
    }

}

