package com.rynortheast.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;



public class MyLooper extends Thread {
    private int number = 0;
    Handler handler;
    String what_about_me = "Named - Данила; Job - Неизвестно;";

    @SuppressLint("HandlerLeak")
    @Override
    public void run() {
        Log.d("MyLooper", "run");
        Looper.prepare();
        handler = new Handler() {
            @SuppressLint("LongLogTag")
            @Override
            public void handleMessage(Message msg){
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d(what_about_me, msg.getData().getString("KEY") + ": " + 20);
                number++;
            }

        };
        Looper.loop();
    }
}

