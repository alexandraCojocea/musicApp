package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class RockFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.music_list, container, false);

        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(R.string.rock_song_one, R.string.rock_singer_one, R.drawable.song_one));
        songs.add(new Song(R.string.rock_song_two, R.string.rock_singer_two, R.drawable.song_two));
        songs.add(new Song(R.string.rock_song_three, R.string.rock_singer_three, R.drawable.song_three));
        songs.add(new Song(R.string.rock_song_four, R.string.rock_singer_four, R.drawable.song_four));
        songs.add(new Song(R.string.rock_song_five, R.string.rock_singer_five, R.drawable.song_five));

        SongAdapter adapter = new SongAdapter(getActivity(), songs, R.color.rock_color);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent songIntent = new Intent(getActivity(), PlaySong.class);
                songIntent.putExtra("songPosition", position);
                Bundle args = new Bundle();
                args.putSerializable("arrayList", (Serializable) songs);
                songIntent.putExtra("bundle", args);
                startActivity(songIntent);
            }
        });
        return rootView;
    }
}
