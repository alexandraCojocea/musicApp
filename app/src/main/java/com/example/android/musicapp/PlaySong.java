package com.example.android.musicapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaySong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_song);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("bundle");
        ArrayList<Song> object = (ArrayList<Song>) args.getSerializable("arrayList");
        int songPosition = getIntent().getIntExtra("songPosition", 0);
        Song currentSong = object.get(songPosition);

        TextView songTitleView = (TextView) findViewById(R.id.content_song_name);
        songTitleView.setText(currentSong.getSongTitleId());
        TextView singerTitleView = (TextView) findViewById(R.id.content_singer_name);
        singerTitleView.setText(currentSong.getSingerTitleId());
        ImageView imageView = (ImageView) findViewById(R.id.song_image);
        imageView.setImageResource(currentSong.getImageResourceId());

        final ImageView button = (ImageView) findViewById(R.id.play_button);
        button.setImageResource(R.drawable.ic_pause_arrow);
        button.setTag("pause");

        button.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                if (button.getTag() == "pause") {
                    button.setImageResource(R.drawable.ic_play_arrow);
                    button.setTag("play");
                } else {
                    button.setImageResource(R.drawable.ic_pause_arrow);
                    button.setTag("pause");
                }
            }


        });
    }

}
