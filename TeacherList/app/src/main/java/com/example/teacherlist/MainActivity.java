package com.example.teacherlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.teacher);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("B.Sc. Honors Computer Science");
        arrayList.add("B.Sc. Honors Mathematics");
        arrayList.add("B.Sc. Honors Physics");
        arrayList.add("B.Com. Honors");
        arrayList.add("BMS");
        arrayList.add("Mathematical Science");
        arrayList.add("Physical Science");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = MainActivity.this.findViewById(R.id.text);
                String s = ((TextView) view).getText().toString();

                if (s.equals("B.Sc. Honors Computer Science"))
                    tv.setText("Dr. Anjali Thukral");
                else if (s.equals("B.Sc. Honors Mathematics"))
                    tv.setText("Dr. Anita Tiwari");
                else if (s.equals("B.Sc. Honors Physics"))
                    tv.setText("Dr. Suhani Saxena");
                else if (s.equals("B.Com. Honors"))
                    tv.setText("Dr. Sweety Kashyap");
                else if (s.equals("BMS"))
                    tv.setText("Dr. Arpit Singhania");
                else if (s.equals("Mathematical Science"))
                    tv.setText("Dr. Abhay Bajpai");
                else if (s.equals("Physical Science"))
                    tv.setText("Dr. Shubham");
            }
        });


    }
}

