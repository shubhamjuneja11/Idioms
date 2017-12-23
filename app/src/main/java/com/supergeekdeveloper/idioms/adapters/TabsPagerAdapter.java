package com.supergeekdeveloper.idioms.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.supergeekdeveloper.idioms.AlphabetFragment;

/**
 * Created by shubhamjuneja11 on 23/12/17.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new AlphabetFragment();
    }

    @Override
    public int getCount() {
        return 26;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }
}
