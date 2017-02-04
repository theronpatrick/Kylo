package com.theronp.taetro;

import android.content.Intent;
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

        View myButton = findViewById(R.id.buttonLaunch);

        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Log.d("test","play sound");
                Intent myintent = new Intent(launch.this, MainActivity.class);
                startActivity(myintent);
            }
        });
    }

}
