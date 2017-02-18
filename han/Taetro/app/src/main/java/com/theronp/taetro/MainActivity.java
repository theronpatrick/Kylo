package com.theronp.taetro;

import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);



        // TODO: Be smart about this
        final View[] buttonArray = {findViewById(R.id.button1),findViewById(R.id.button2),findViewById(R.id.button3),findViewById(R.id.button4),findViewById(R.id.button5),findViewById(R.id.button6),findViewById(R.id.button7),findViewById(R.id.button8), findViewById(R.id.button9), findViewById(R.id.button10), findViewById(R.id.button11), findViewById(R.id.button12)};

        // Get audio pool
        AudioAttributes attrs = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        final SoundPool sp = new SoundPool.Builder()
                .setMaxStreams(16)
                .setAudioAttributes(attrs)
                .build();

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        final int soundIds[] = new int[12];
        final int streamIds[] = new int[12];

        // Load sounds into array
        soundIds[0] = sp.load(this, R.raw.pad2, 1);
        soundIds[1] = sp.load(this, R.raw.pad3, 1);
        soundIds[2] = sp.load(this, R.raw.pad4, 1);
        soundIds[3] = sp.load(this, R.raw.pad1, 1);
        soundIds[4] = sp.load(this, R.raw.glass1, 1);
        soundIds[5] = sp.load(this, R.raw.glass2, 1);
        soundIds[6] = sp.load(this, R.raw.bucket1, 1);
        soundIds[7] = sp.load(this, R.raw.glass4, 1);
        soundIds[8] = sp.load(this, R.raw.glass3, 1);
        soundIds[9] = sp.load(this, R.raw.kick1, 1);
        soundIds[10] = sp.load(this, R.raw.toaster1, 1);
        soundIds[11] = sp.load(this, R.raw.bucket2, 1);

        for (int i = 0; i < buttonArray.length; i++) {

            View myButton = buttonArray[i];

            // Turn off default click
            myButton.setSoundEffectsEnabled(false);


            final int finalI = i;
            myButton.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    // ... Respond to touch events
                    int action = MotionEventCompat.getActionMasked(event);

                    String DEBUG_TAG = "test";

                    switch(action) {
                        case (MotionEvent.ACTION_DOWN) :
                            Log.d(DEBUG_TAG,"Action was DOWN");
                            playSound(sp, soundIds, streamIds, finalI);
                            buttonArray[finalI].setBackgroundColor(0xFFFF5554);
                            return true;
                        case (MotionEvent.ACTION_UP) :
                            Log.d(DEBUG_TAG,"Action was UP");
                            buttonArray[finalI].setBackgroundColor(0xFFDB363F);
                            return true;
                        default :
                            return true;
                    }
                }
            });
        }


    }

    public void playSound(SoundPool sp, int[] soundIds, int[] streamIds, int i) {
        Log.d("test","play sound");


        sp.stop(streamIds[i]);

        streamIds[i] = sp.play(soundIds[i], 1, 1, 1, 0, 1);

    }


}
