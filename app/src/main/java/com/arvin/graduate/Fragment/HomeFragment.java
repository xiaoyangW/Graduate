package com.arvin.graduate.Fragment;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arvin.graduate.Adapter.HomeViewPageAdpter;
import com.arvin.graduate.Contans.MyContan;
import com.arvin.graduate.Entity.Exercise;
import com.arvin.graduate.Entity.Home_banner;
import com.arvin.graduate.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.R.string.ok;

/**
 * Created by WXY on 2016/7/12.
 */

public class HomeFragment extends Fragment {
    private String HOMESEVLET = MyContan.PIC+"home";
    List<Home_banner> mHome_hanner;
    private ViewPager vp_home;
    private ImageView iv_test1;
    List<ImageView> pagelist = new ArrayList<>();
    private HomeViewPageAdpter pageadpter;
    //private List<ImageView> pagelist;
    Handler homeHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg != null){
                mHome_hanner = (List<Home_banner>) msg.obj;
                for (Home_banner home_banner : mHome_hanner){
                    ImageView imageView = new ImageView(getContext());
                    imageView.setAdjustViewBounds(true);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Picasso.with(getContext()).load(home_banner.getPic()).into(imageView);
                    pagelist.add(imageView);
                }
                pageadpter = new HomeViewPageAdpter(pagelist);
                vp_home.setAdapter(pageadpter);
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
       Toolbar home_toolbar = (Toolbar) view.findViewById(R.id.home_toolbar);
        iv_test1 = (ImageView) view.findViewById(R.id.iv_test1);
        vp_home = (ViewPager) view.findViewById(R.id.vp_home);
        setHasOptionsMenu(true);
        ((AppCompatActivity)getActivity()).setSupportActionBar(home_toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.code_ico_black);
        if (mHome_hanner == null) {
            getImags();//获取网络数据
        }
        if (pageadpter != null){
            vp_home.setAdapter(pageadpter);
        }
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.i(MyContan.LOG,"HomeFragment");
        menu.clear();
        inflater.inflate(R.menu.drawer_view,menu);
    }

    private void getImags(){
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(HOMESEVLET).build();
        Log.i(MyContan.LOG,HOMESEVLET);
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("wxy","连接失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               //子线程
                String string = response.body().string();
                Log.i("wxy",string);
                Gson gson = new Gson();
                Exercise exercise = gson.fromJson(string, Exercise.class);
                List<Home_banner> home_banner = exercise.getHome_banner();
                Message msg = homeHandler.obtainMessage();
                msg.obj = home_banner;
                homeHandler.sendMessage(msg);
                String request = exercise.getResponse();
                Log.i(MyContan.LOG,request);
            }
        });
    }
}
