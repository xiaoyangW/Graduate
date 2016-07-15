package com.arvin.graduate.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arvin.graduate.Contans.MyContan;
import com.arvin.graduate.Entity.Home_banner;
import com.arvin.graduate.Fragment.ImageFragmen;

import java.util.List;

/**
 * Created by acer1 on 2016/7/15.
 */

public class HomeViewPageAdpter extends PagerAdapter {
    List<ImageView> list;

    public HomeViewPageAdpter(List<ImageView> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * 初始化视图
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    /**
     * 销毁视图
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // super.destroyItem(container, position, object);
        container.removeView(list.get(position));
    }


}
