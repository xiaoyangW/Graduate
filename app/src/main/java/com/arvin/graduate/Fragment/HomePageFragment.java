package com.arvin.graduate.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arvin.graduate.Contans.MyContan;
import com.squareup.picasso.Picasso;

/**
 * Created by acer1 on 2016/7/15.
 */

public class HomePageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ImageView imageView = new ImageView(inflater.getContext());
        Bundle bundle = getArguments();
        //设置边框对齐
        imageView.setAdjustViewBounds(true);
        //缩放
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Picasso.with(getContext()).load(bundle.getInt(MyContan.TAG_IMAGE_ID)).into(imageView);
        return imageView;
    }
}
