package com.example.menuword;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuitem,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //int v = R.layout.activity_main;
        //setContentView(R.layout.activity_main);

        TextView w = findViewById(R.id.word);
        TextView m = findViewById(R.id.mean);


        switch(item.getItemId()){
            case R.id.consider :
                w.setText("Consider : ");
                m.setText("Deem to be");
                return true;

            case R.id.approach :
                w.setText("Approach : ");
                m.setText("Move Towards");
                return true;

            case R.id.accord :
                w.setText("Accord : ");
                m.setText("Concurrence of opinion");
                return true;

            case R.id.happy :
                w.setText("Happy : ");
                m.setText("Glad");
                return true;

            default :
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
