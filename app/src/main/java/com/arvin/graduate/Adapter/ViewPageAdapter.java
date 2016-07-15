package com.arvin.graduate.Adapter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.arvin.graduate.Contans.MyContan;
import com.arvin.graduate.Fragment.ImageFragmen;


/**
 * Created by WXY on 2016/7/12.
 */

public class ViewPageAdapter extends FragmentPagerAdapter {
    int mids[];

    public ViewPageAdapter(FragmentManager fm , int[] mids) {
        super(fm);
        this.mids = mids;
    }


    @Override
    public int getCount() {
        return mids.length;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new ImageFragmen();
        Bundle bundle = new Bundle();
        bundle.putInt(MyContan.TAG_IMAGE_ID,MyContan.IMAGES[position]);
        fragment.setArguments(bundle);
        return fragment;
    }
}
