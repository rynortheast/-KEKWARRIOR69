package com.rynortheast.mirea_project_v2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.view.View;

public class player__service extends Service {

    static final String TAG = "PlayerService";
    private MediaPlayer mediaPlayer;

    public player__service() { }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onDestroy() {
        mediaPlayer.stop();
    }
    @Override
    public void onCreate(){
        mediaPlayer=MediaPlayer.create(this, R.raw.ernesto_cortazar_dancing_waves);
        mediaPlayer.setLooping(true);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        mediaPlayer.start();
        return START_STICKY;
    }

    public void onClickPlayMusic(View view) {
        startService(new Intent(player__service.this, player__service.class));
    }
    public void onClickStopMusic(View view) {
        stopService(new Intent(player__service.this, player__service.class));
    }
}