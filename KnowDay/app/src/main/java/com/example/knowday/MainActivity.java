package com.example.knowday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    String text_month;
    String text_year;
    String text_date;
    //Button know = findViewById(R.id.knowday);

    int leap_check(int mm,int yy)
    {
        int leap=0;
        if( yy%100 != 0 && yy%4 == 0 && ( mm == 1 || mm == 2 ) )
            leap=1;
        else if( yy%100 == 0 && yy%400 == 0 && ( mm == 1 || mm == 2 ) )
            leap=1;

        return leap;
    }

    boolean date_check(int dd,int mm,int yy)
    {
        boolean flag=true;

        if( yy < 1600 || yy > 2399 )
            flag=false;
        else if( mm < 1 || mm > 12 )
            flag=false;

        else if( mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12 )
        {
            if(  dd < 1 || dd > 31 )
                flag=false;
        }

        else if(  mm == 4 || mm == 6 || mm == 9 || mm == 11 )
        {
            if(  dd < 1 || dd > 30 )
                flag=false;
        }

        else
        {
            int x=leap_check(mm,yy);
            if( x == 1 )
            {
                if( dd < 1 || dd > 29 )
                    flag=false;
            }
            else
            {
                if( dd < 1 || dd > 28 )
                    flag=false;
            }
        }

        return flag;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        Button know = findViewById(R.id.knowday);
        know.setOnClickListener((View.OnClickListener)this);

        Button b1 = findViewById(R.id.one);
        Button b2 = findViewById(R.id.two);
        Button b3 = findViewById(R.id.three);
        Button b4 = findViewById(R.id.four);
        Button b5 = findViewById(R.id.five);
        Button b6 = findViewById(R.id.six);
        Button b7 = findViewById(R.id.seven);
        Button b8 = findViewById(R.id.eight);
        Button b9 = findViewById(R.id.nine);
        Button b10 = findViewById(R.id.ten);
        Button b11= findViewById(R.id.eleven);
        Button b12 = findViewById(R.id.twelve);
        Button b13 = findViewById(R.id.thirteen);
        Button b14 = findViewById(R.id.fourteen);
        Button b15 = findViewById(R.id.fifteen);
        Button b16 = findViewById(R.id.sixteen);
        Button b17 = findViewById(R.id.seventeen);
        Button b18 = findViewById(R.id.eighteen);
        Button b19 = findViewById(R.id.nineteen);
        Button b20 = findViewById(R.id.twenty);
        Button b21 = findViewById(R.id.twentyone);
        Button b22 = findViewById(R.id.twentytwo);
        Button b23 = findViewById(R.id.twentythree);
        Button b24 = findViewById(R.id.twentyfour);
        Button b25 = findViewById(R.id.twentyfive);
        Button b26 = findViewById(R.id.twentysix);
        Button b27 = findViewById(R.id.twentyseven);
        Button b28 = findViewById(R.id.twentyeight);
        Button b29 = findViewById(R.id.twentynine);
        Button b30 = findViewById(R.id.thirty);
        Button b31 = findViewById(R.id.thirtyone);

        b1.setOnClickListener((View.OnClickListener) this);
        b2.setOnClickListener((View.OnClickListener) this);
        b3.setOnClickListener((View.OnClickListener) this);
        b4.setOnClickListener((View.OnClickListener) this);
        b5.setOnClickListener((View.OnClickListener) this);
        b6.setOnClickListener((View.OnClickListener) this);
        b7.setOnClickListener((View.OnClickListener) this);
        b8.setOnClickListener((View.OnClickListener) this);
        b9.setOnClickListener((View.OnClickListener) this);
        b10.setOnClickListener((View.OnClickListener) this);
        b11.setOnClickListener((View.OnClickListener) this);
        b12.setOnClickListener((View.OnClickListener) this);
        b13.setOnClickListener((View.OnClickListener) this);
        b14.setOnClickListener((View.OnClickListener) this);
        b15.setOnClickListener((View.OnClickListener) this);
        b16.setOnClickListener((View.OnClickListener) this);
        b17.setOnClickListener((View.OnClickListener) this);
        b18.setOnClickListener((View.OnClickListener) this);
        b19.setOnClickListener((View.OnClickListener) this);
        b20.setOnClickListener((View.OnClickListener) this);
        b21.setOnClickListener((View.OnClickListener) this);
        b22.setOnClickListener((View.OnClickListener) this);
        b23.setOnClickListener((View.OnClickListener) this);
        b24.setOnClickListener((View.OnClickListener) this);
        b25.setOnClickListener((View.OnClickListener) this);
        b26.setOnClickListener((View.OnClickListener) this);
        b27.setOnClickListener((View.OnClickListener) this);
        b28.setOnClickListener((View.OnClickListener) this);
        b29.setOnClickListener((View.OnClickListener) this);
        b30.setOnClickListener((View.OnClickListener) this);
        b31.setOnClickListener((View.OnClickListener) this);

        Spinner sp = findViewById(R.id.monthspinner);
        String mnth[]=getResources().getStringArray(R.array.months);
        List<String> monthlist = new ArrayList<>(Arrays.asList(mnth));
        monthlist.add(0,"January");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,monthlist);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                text_month = ((TextView)view).getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        if(((Button)v).getText().toString().equals("Know Day"))
        {
            EditText tv_year = findViewById(R.id.yyyy);
            text_year = tv_year.getText().toString();

            int mm;

            switch(text_month)
            {
                case "January" : mm = 1; break;
                case "February" : mm = 2; break;
                case "March" : mm = 3; break;
                case "April" : mm = 4; break;
                case "May" : mm = 5; break;
                case "June" : mm = 6; break;
                case "July" : mm = 7; break;
                case "August" : mm = 8; break;
                case "September" : mm = 9; break;
                case "October" : mm = 10; break;
                case "November" : mm = 11; break;
                case "December" : mm = 12; break;
                default: mm = 1;
            }

            text_month = Integer.toString(mm);

            TextView tv = findViewById(R.id.date);
            text_date = tv.getText().toString();

            int dd=Integer.parseInt(text_date);
            //int mm=Integer.parseInt(text_month);
            int yy=Integer.parseInt(text_year);

            if(text_date.equals("") || text_year.equals(""))
                Toast.makeText(MainActivity.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
            else
                {
                    boolean flag = date_check(dd,mm,yy);

                    if (flag == false)
                        Toast.makeText(MainActivity.this, "Sorry! Invalid Date", Toast.LENGTH_SHORT).show();

                    else
                     {
                        Intent I = new Intent(MainActivity.this, findDay.class);
                        I.putExtra("Date", text_date);
                        I.putExtra("Month", text_month);
                        I.putExtra("Year", text_year);
                        startActivity(I);
                        finish();
                    }
                }
            }

        else
        {
            text_date = ((Button)v).getText().toString();
            TextView t = findViewById(R.id.date);
            t.setText(text_date);
        }

    }
}
