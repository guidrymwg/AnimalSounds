package com.lightcone.animalsounds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add click listeners to all the ImageButtons

        View button1 = findViewById(R.id.imageButton);
        View button2 = findViewById(R.id.imageButton2);
        View button3 = findViewById(R.id.imageButton3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    // Required method if OnClickListener is implemented

    @Override
    public void onClick(View v) {

        // Play only one sound at a time
        if(mp != null) mp.release();

        // Find which ImageButton was pressed and take appropriate action

        switch(v.getId()){

            // The cow button
            case R.id.imageButton:
                //Log.i("Test", "Cow Button");
                mp = MediaPlayer.create(this, R.raw.cow);
                break;

            // The duck button
            case R.id.imageButton2:
                //Log.i("Test", "Duck Button");
                mp = MediaPlayer.create(this, R.raw.duck);
                break;

            // The sheep button
            case R.id.imageButton3:
                //Log.i("Test", "Sheep Button");
                mp = MediaPlayer.create(this, R.raw.sheep);
                break;

        }
        mp.seekTo(0);
        mp.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        // Release the MediaPlayer if going into background if it isn't null
        if(mp != null) mp.release();
    }
}
