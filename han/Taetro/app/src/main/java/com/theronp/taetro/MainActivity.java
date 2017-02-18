package com.theronp.taetro;

import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
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

        // int[] soundArray = {R.raw.pad2, R.raw.pad3, R.raw.pad4, R.raw.pad1, R.raw.glass1, R.raw.glass2, R.raw.bucket1, R.raw.glass4, R.raw.glass3, R.raw.kick1, R.raw.toaster1, R.raw.bucket2};

        int[] soundArray = {R.raw.pad2, R.raw.pad3, R.raw.pad4, R.raw.pad1, R.raw.glass1, R.raw.glass2, R.raw.bucket1, R.raw.glass4, R.raw.glass3, R.raw.kick1, R.raw.toaster1, R.raw.bucket2};

        // TODO: Be smart about this
        View[] buttonArray = {findViewById(R.id.button1),findViewById(R.id.button2),findViewById(R.id.button3),findViewById(R.id.button4),findViewById(R.id.button5),findViewById(R.id.button6),findViewById(R.id.button7),findViewById(R.id.button8), findViewById(R.id.button9), findViewById(R.id.button10), findViewById(R.id.button11), findViewById(R.id.button12)};

        MediaPlayer[] mediaPlayerArray = new MediaPlayer[12];

        for (int i = 0; i < soundArray.length; i++) {

            final MediaPlayer mp = MediaPlayer.create(this, soundArray[i]);

            AssetManager assets = this.getAssets();

            mediaPlayerArray[i] = mp;

            View myButton = buttonArray[i];

            final int buttonIndex = i;

            Log.d("test", "in loop");
            Log.d("test", Integer.toString(i));
            Log.d("test", Integer.toString(soundArray[i]));

            myButton.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    // ... Respond to touch events
                    int action = MotionEventCompat.getActionMasked(event);

                    String DEBUG_TAG = "test";

                    Log.d("test","index tapped");
                    Log.d("test", Integer.toString(buttonIndex));

                    switch(action) {
                        case (MotionEvent.ACTION_DOWN) :
                            Log.d(DEBUG_TAG,"Action was DOWN");
                            try {
                                playSound(mp);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return true;
                        case (MotionEvent.ACTION_UP) :
                            Log.d(DEBUG_TAG,"Action was UP");
                            return true;
                        case (MotionEvent.ACTION_CANCEL) :
                            Log.d(DEBUG_TAG,"Action was CANCEL");
                            return true;
                        case (MotionEvent.ACTION_OUTSIDE) :
                            Log.d(DEBUG_TAG,"Movement occurred outside bounds " +
                                    "of current screen element");
                            return true;
                        default :
                            return true;
                    }
                }
            });
        }


    }

    public void playSound(MediaPlayer mp) throws IOException {
        Log.d("test","play sound");

        if (mp.isPlaying()) {
            mp.stop();
            mp.prepare();
            mp.start();
        } else {
            mp.start();
        }

    }

    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }






}
