package com.example.hello;

//import android.support.v4.app.Fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private static int TAB_COUNT = 3;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return ProfileFragment.newInstance();
            case 1:
                return MatchesFragment.newInstance();
            case 2:
                return SettingsFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return ProfileFragment.TITLE;

            case 1:
                return MatchesFragment.TITLE;

            case 2:
                return SettingsFragment.TITLE;
        }
        return super.getPageTitle(position);
    }
}
















