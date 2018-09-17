package com.example.android.musicapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    private int mColorResourceId;

    public SongAdapter(Context context, ArrayList<Song> songs, int colorResourceId) {
        super(context, 0, songs);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.music_item, parent, false);
        }

        Song currentSong = getItem(position);
        TextView songTitleView = (TextView) listItemView.findViewById(R.id.song_name);
        songTitleView.setText(currentSong.getSongTitleId());
        TextView singerTitleView = (TextView) listItemView.findViewById(R.id.singer_name);
        singerTitleView.setText(currentSong.getSingerTitleId());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentSong.getImageResourceId());
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
