package com.theronp.taetro;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class launch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Go to app
        View myButton = findViewById(R.id.soundpackText);

        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent myintent = new Intent(launch.this, MainActivity.class);
                startActivity(myintent);
            }
        });

        // Go to youtube
        View imageButton = findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/channel/UCNRFvq0JOm5VqHIBDDQgkMA")));
            }
        });

    }

}
