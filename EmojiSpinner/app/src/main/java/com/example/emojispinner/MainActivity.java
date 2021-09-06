package com.example.emojispinner;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        final ImageView imgview = findViewById(R.id.imageView);

        String img[]=getResources().getStringArray(R.array.images);
        List<String> arrlist = new ArrayList<>(Arrays.asList(img));
        arrlist.add(0,"Select Image");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,arrlist);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = ((TextView)view).getText().toString();
                switch (text)
                {
                    case "Select Image" :
                        onNothingSelected(parent);
                        break;

                    case "smile" :
                        imgview.setImageResource(R.drawable.smile);
                        break;

                    case "smirk" :
                        imgview.setImageResource(R.drawable.smirk);
                        break;

                    case "sad" :
                        imgview.setImageResource(R.drawable.sad);
                        break;

                    case "relaxed" :
                        imgview.setImageResource(R.drawable.relaxed);
                        break;

                    case "shocked" :
                        imgview.setImageResource(R.drawable.shocked);
                        break;

                    case "wink" :
                        imgview.setImageResource(R.drawable.wink);
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
}
