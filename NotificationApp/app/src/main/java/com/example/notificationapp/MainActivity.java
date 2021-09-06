package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel("NotificationCHNL","NotificationChannel", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Notification sample description");

            //register
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        btn = findViewById(R.id.btn);
        btn.setOnClickListener((View.OnClickListener)this);
    }

    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent(this, second.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent1, 0);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"NotificationCHNL");
        builder.setContentTitle("Notification Title");
        builder.setContentText("Notification Text - Hello ! How are you ?");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setAutoCancel(true);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setContentIntent(pendingIntent);

        //trigger
        NotificationManagerCompat ManagerCompact = NotificationManagerCompat.from(this);
        ManagerCompact.notify(1,builder.build());
    }
}
