package com.jay.epaisademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

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

        Glide.with(this).load(song.getArtworkUrl100())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(imageView);
        collectionName.setText("Collection Name : "+String.valueOf(song.getCollectionName()));
        trackName.setText("Track Name : "+ String.valueOf(song.getTrackName()));
        collectionPrice.setText("Collection Price : "+String.valueOf(song.getCollectionPrice()));
        trackPrice.setText("Track Price : "+String.valueOf(song.getTrackPrice()));
        releaseDate.setText("Release Date : "+String.valueOf(song.getReleaseDate()));
        trackTime.setText("Track Time : "+String.valueOf(song.getTrackTimeMillis()));
        genrneName.setText("Genre Name : "+String.valueOf(song.getPrimaryGenreName()));
    }
}
