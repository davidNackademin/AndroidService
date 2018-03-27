package com.example.david.thus27marsandroidservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;



/**
 * Created by david on 2018-03-27.
 */

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyWorkerThread");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("MyIntentService", "onCreate: " + Thread.currentThread().getName());

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("MyIntentService", "onHandle: " + Thread.currentThread().getName());

        for(int i = 1; i <= 10; i++) {
            Log.d("MyIntentService", "counter is: " + i);

            try {
               Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService", "onDestroy: " + Thread.currentThread().getName());
    }


}
