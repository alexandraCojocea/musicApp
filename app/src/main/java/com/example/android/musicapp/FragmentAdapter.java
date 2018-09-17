package com.example.android.musicapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public FragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new DanceFragment();
        } else if (position == 1) {
            return new PopFragment();
        } else if (position == 2) {
            return new JazzFragment();
        } else {
            return new RockFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.dance);
        } else if (position == 1) {
            return mContext.getString(R.string.pop);
        } else if (position == 2) {
            return mContext.getString(R.string.jazz);
        } else {
            return mContext.getString(R.string.rock);
        }
    }
}

