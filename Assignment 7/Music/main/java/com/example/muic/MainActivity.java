package com.example.muic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View v){

        if (player==null){
            player=MediaPlayer.create(this,R.raw.sadka);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    StopPlayer();
                }
            });
        }

        player.start();
    }

    public void Pause(View v){

        if (player!=null){

            player.pause();
        }


    }

    public void Stop(View v){
  StopPlayer();

    }



    @Override
    protected void onStop() {
        super.onStop();
        StopPlayer();
    }

    private void StopPlayer()

    {
        if (player!=null)
        {
            player.release();
            player=null;
            Toast.makeText(this, "Media Player released", Toast.LENGTH_SHORT).show();
        }
    }

}
