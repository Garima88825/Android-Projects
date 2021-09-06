package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
//import com.example.menu.dataBinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    //private ActivityMainBinding binding;

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuitem,menu);
        return true;
    }

//    public boolean onOptionsItemSelected(MenuItem item)
//    {
//        View v = binding.getRoot();
//        switch(item.getItemId()){
//            case R.id.red :
//                v.setBackgroundColor();
//                return true;
//
//            case R.id.green :
//                v.setBackgroundColor();
//                return true;
//
//            case R.id.blue :
//                v.setBackgroundColor();
//                return true;
//
//        }
//    }

    //@Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//    }
}
