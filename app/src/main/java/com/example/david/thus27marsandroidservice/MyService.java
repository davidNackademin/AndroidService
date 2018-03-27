package com.example.david.thus27marsandroidservice;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by david on 2018-03-27.
 */

public class MyService  extends Service {

   @Override
   public int onStartCommand(Intent intent, int flags, int startId) {

       Log.d("MyService", "onstartCommand, Thread: " + Thread.currentThread().getName());
//       int sleepTime = intent.getIntExtra("sleepTime", 1);
//
//       try {
//           Thread.sleep(sleepTime);
//       } catch (InterruptedException e) {
//           e.printStackTrace();
//       }

       MyAsyncTask task = new MyAsyncTask();
       task.execute();

       return START_STICKY;
   }



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
       super.onDestroy();

       Log.d("MyService", "onDestroy"   );

    }


}

class MyAsyncTask extends AsyncTask<Integer, String, Void> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Log.d("MyTask", "onPreExecute, Thread: " + Thread.currentThread().getName());
    }


    @Override
    protected Void doInBackground(Integer... integers) {
        Log.d("MyTask", "doInBackground, Thread: " + Thread.currentThread().getName());

        for(int i = 1; i <= 10; i++) {
            publishProgress("Counter is: " + String.valueOf(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);

        Log.d("MyTask", "onProgressUpdate" + values[0] + "Thread: " + Thread.currentThread().getName());

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Log.d("MyTask", "onPostExecute, Thread: " + Thread.currentThread().getName());


    }

}