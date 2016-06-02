package com.jay.epaisademo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by JPatel on 02-06-16.
 */
public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.MyViewHolder> {

    private List<Song> songsList;
    private Context mContext;

    public SongsAdapter(Context context, List<Song> songsList) {
        this.songsList = songsList;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Song song = songsList.get(position);
        Glide.with(mContext).load(song.getArtworkUrl100())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(holder.imageView);
        holder.trackName.setText(song.getTrackName());
        holder.trackPrice.setText(String.valueOf(song.getTrackPrice()));
        holder.trackTime.setText(String.valueOf(song.getTrackTimeMillis()));
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView trackName, trackPrice, trackTime;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.image);
            trackName = (TextView) view.findViewById(R.id.trackName);
            trackPrice = (TextView) view.findViewById(R.id.trackPrice);
            trackTime = (TextView) view.findViewById(R.id.trackTime);
        }
    }
}
