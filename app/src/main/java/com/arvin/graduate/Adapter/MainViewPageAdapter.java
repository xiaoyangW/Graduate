package com.arvin.graduate.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by acer1 on 2016/7/12.
 */

public class MainViewPageAdapter extends FragmentPagerAdapter{
    Class[] classes;
    public MainViewPageAdapter(FragmentManager fm,Class[] classes) {
        super(fm);
        this.classes = classes;
    }

    @Override
    public Fragment getItem(int position) {
        try {
            Fragment o = (Fragment) Class.forName(classes[position].getName()).newInstance();
            return o;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return classes.length;
    }
}
