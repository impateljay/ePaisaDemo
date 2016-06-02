package com.jay.epaisademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class SongsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_details);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        TextView collectionName = (TextView) findViewById(R.id.collectionName);
        TextView trackName = (TextView) findViewById(R.id.trackName);
        TextView collectionPrice = (TextView) findViewById(R.id.collectionPrice);
        TextView trackPrice = (TextView) findViewById(R.id.trackPrice);
        TextView releaseDate = (TextView) findViewById(R.id.releaseDate);
        TextView trackTime = (TextView) findViewById(R.id.trackTime);
        TextView genrneName = (TextView) findViewById(R.id.genrneName);

        Intent intent = getIntent();
        Song song = (Song) intent.getSerializableExtra("Song");

        setTitle(String.valueOf(song.getTrackName()));

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        try {
            String dateTime = String.valueOf(song.getReleaseDate()).replace("Z", "GMT+00:00");
            date = simpleDateFormat.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Glide.with(this).load(song.getArtworkUrl100())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(imageView);
        collectionName.setText("Collection Name : " + String.valueOf(song.getCollectionName()));
        trackName.setText("Track Name : " + String.valueOf(song.getTrackName()));
        collectionPrice.setText("Collection Price : $" + String.valueOf(song.getCollectionPrice()));
        trackPrice.setText("Track Price : $" + String.valueOf(song.getTrackPrice()));
        releaseDate.setText("Release Date : " + String.valueOf(date));
        trackTime.setText("Track Time : " + String.valueOf(TimeUnit.MILLISECONDS.toMinutes(Long.parseLong(String.valueOf(song.getTrackTimeMillis()))) + ":" + TimeUnit.MILLISECONDS.toSeconds(Long.parseLong(String.valueOf(song.getTrackTimeMillis()))) % 60) + " Min");
        genrneName.setText("Genre Name : " + String.valueOf(song.getPrimaryGenreName()));
    }
}
