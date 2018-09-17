package com.example.android.musicapp;

import java.io.Serializable;

public class Song implements Serializable {
    private int mSongTitleId;

    private int mSingerTitleId;

    private int mImageResourceId;

    public Song(int songTitleId, int singerTitleId, int imageResourceId) {
        mSongTitleId = songTitleId;
        mSingerTitleId = singerTitleId;
        mImageResourceId = imageResourceId;

    }

    public int getSongTitleId() {
        return mSongTitleId;
    }

    public int getSingerTitleId() {
        return mSingerTitleId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
