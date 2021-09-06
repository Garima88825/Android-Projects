package com.example.sendapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mwebsite;
    private EditText mlocation;
    private EditText mtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mwebsite = (EditText) findViewById(R.id.inpwebsite);
        mlocation = (EditText) findViewById(R.id.inplocation);
        mtext = (EditText) findViewById(R.id.inptext);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        if (uri != null) {
            String uri_string = "URI: " + uri.toString();
        }
    }

    public void openWebsite(View view) {

        String url = mwebsite.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void openLocation(View view) {
        String loc = mlocation.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        String txt = mtext.getText().toString();
        Intent I = new Intent();
        I.setAction(Intent.ACTION_SEND);
        I.putExtra(Intent.EXTRA_TEXT, txt);
        I.setType("text/plain");
        Intent In = Intent.createChooser(I,null);
        startActivity(In);
    }

}
