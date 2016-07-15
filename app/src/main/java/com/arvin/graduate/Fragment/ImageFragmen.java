package com.arvin.graduate.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arvin.graduate.Contans.MyContan;

/**
 * Created by acer1 on 2016/7/12.
 */

public class ImageFragmen extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ImageView imageView = new ImageView(inflater.getContext());
        Bundle bundle = getArguments();
        //设置边框对齐
        imageView.setAdjustViewBounds(true);
        //缩放
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(bundle.getInt(MyContan.TAG_IMAGE_ID));
        return imageView;
    }
}
