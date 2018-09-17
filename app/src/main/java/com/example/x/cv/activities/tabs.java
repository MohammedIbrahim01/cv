package com.example.x.cv.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class tabs extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public tabs(FragmentManager fm, int NumOfTabs ) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Languages tab1 = new Languages();
                return tab1;
            case 1:
                Sports tab2 = new Sports();
                return tab2;
            default:

                return null;
        }
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
