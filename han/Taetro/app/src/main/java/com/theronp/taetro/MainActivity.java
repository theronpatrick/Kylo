package com.theronp.taetro;

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

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.bucket1);


        View myButton = findViewById(R.id.button1);
        myButton.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // ... Respond to touch events
                int action = MotionEventCompat.getActionMasked(event);

                String DEBUG_TAG = "test";

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

    public void buttonClick(View view) {
        Log.d("t", "sup");
    }






}
