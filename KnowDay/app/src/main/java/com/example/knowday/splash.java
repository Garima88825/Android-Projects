package com.example.knowday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class splash extends AppCompatActivity {

    //private  static  int SPLASH_SCREEN_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);



         new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent I = new Intent(splash.this,MainActivity.class);
                startActivity(I);
                finish();
            }
        },2000);

         /*
        Thread th = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                    Intent I=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(I);
                    finish();
                }
                catch (Exception E){

                }
            }
        };
        th.start();
         */
    }
}
