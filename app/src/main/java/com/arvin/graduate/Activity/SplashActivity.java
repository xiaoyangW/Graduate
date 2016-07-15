package com.arvin.graduate.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.arvin.graduate.Contans.MyContan;
import com.arvin.graduate.R;

/**
 * Created by WXY on 2016/7/12.
 */

public class SplashActivity extends AppCompatActivity{
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (isFrishRun()){
                startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                finish();
            }else {
                //不是第一次
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.postDelayed(runnable,200);
    }

    private boolean isFrishRun(){
        SharedPreferences sharedPreferences = this.getSharedPreferences(MyContan.ISFRISHRUN,MODE_PRIVATE);
        boolean isFrishRun = sharedPreferences.getBoolean(MyContan.ISFRISHRUN,true);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!isFrishRun){
            return  false;
        }else {
            editor.putBoolean(MyContan.ISFRISHRUN,false);
            editor.commit();
            return true;
        }
    }

}
