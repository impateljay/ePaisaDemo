package com.jay.epaisademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SongsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_details);

        Intent intent = getIntent();
        Song song = (Song) intent.getSerializableExtra("Song");
        Toast.makeText(getApplicationContext(), song.getTrackName() + " is selected!", Toast.LENGTH_SHORT).show();
    }
}
