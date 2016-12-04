package com.example.lucas.cardproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lucas on 26/10/2016.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments){
        super(fm);

        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int i){
        return mFragments.get(i);
    }

    @Override
    public int getCount(){

        return mFragments.size();
    }
}
