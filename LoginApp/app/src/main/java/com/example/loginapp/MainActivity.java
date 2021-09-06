package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText user;
    EditText pswrd;
    String st;
    String p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.loginbtn);
        user=findViewById(R.id.username);
        pswrd=findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                st=user.getText().toString();
                p=pswrd.getText().toString();
                if(st.equals("User") && p.equals("12345"))
                {
                    intent.putExtra("Username",st);
                    startActivity(intent);
                }
                else
                {
//                    String text="Invalid Username or Password ! ";
                    Toast.makeText(MainActivity.this,"Invalid Username or Password ! ",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
