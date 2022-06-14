package com.example.musicplayerspotfai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SeekBar seekBar, seekBarVolume;
    private AudioManager audioManager;
    private ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.m4);

        seekBarVolume = findViewById(R.id.seekBarVolume);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        seekBarVolume.setMax(maxVolume);
        seekBarVolume.setProgress(curVolume);
        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }
    public void tocar(View view){
        mediaPlayer.start();
        imageView3 = (ImageView)findViewById(R.id.imageView3);
        imageView3.setVisibility(View.VISIBLE);
    }
    public void pausar(View view){
        mediaPlayer.pause();
    }
    public void parar(View view){
        mediaPlayer.stop();
        imageView3.setVisibility(View.INVISIBLE);
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.m4);
    }

}