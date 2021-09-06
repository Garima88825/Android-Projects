package com.example.knowday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class findDay extends AppCompatActivity {



    int leap_check(int mm,int yy)
    {
        int leap=0;
        if( yy%100 != 0 && yy%4 == 0 && ( mm == 1 || mm == 2 ) )
            leap=1;
        else if( yy%100 == 0 && yy%400 == 0 && ( mm == 1 || mm == 2 ) )
            leap=1;

        return leap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_find_day);

        String xdd;
        String xmm;
        String xyy;

        xdd = getIntent().getExtras().getString("Date");
        xmm = getIntent().getExtras().getString("Month");
        xyy = getIntent().getExtras().getString("Year");
        int dd=Integer.parseInt(xdd);
        int mm=Integer.parseInt(xmm);
        int yy=Integer.parseInt(xyy);

        TextView xxdate = findViewById(R.id.xdate);
        TextView xxday = findViewById(R.id.xday);

        int leap=leap_check(mm,yy);
        int mcode[]={1,4,4,0,2,5,0,3,6,1,4,6};
        int ccode[]={6,4,2,0,6,4,2,0};
        String day[]={"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};

        int ycode=(yy%100)/4 + (yy%100);
        int x=yy/100;

        int day_num= (dd + ycode + mcode[mm-1] + ccode[x-16] - leap ) % 7;

        xxdate.setText(xdd+"."+xmm+"."+xyy);
        xxday.setText(day[day_num]);

        //System.out.println("The day at this date : "+day[day_num]);
    }
}
