package com.example.shan.appstatuspreferences;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private int count;
    private String exeCountKey = "exeCount";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getPreferences(MODE_PRIVATE);
        getExeCount();
        textView = (TextView) findViewById(R.id.tvAppExeCount);
        textView.setText("App Executed " + count + " times");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(exeCountKey, ++count);
        editor.commit();
    }
    public void getExeCount(){
        this.count = sharedPreferences.getInt(exeCountKey, 1);
    }

}
