package com.example.david.thus27marsandroidservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startMyService(View view) {
       // Intent intent = new Intent(this, MyService.class);
        //intent.putExtra("sleepTime" , 10000);

        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }

    public void stopMyService(View view) {
        Intent intent = new Intent(this, MyService.class);

        stopService(intent);

    }


}
