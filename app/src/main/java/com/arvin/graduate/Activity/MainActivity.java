package com.arvin.graduate.Activity;

import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.arvin.graduate.Adapter.MainViewPageAdapter;
import com.arvin.graduate.Contans.MyContan;
import com.arvin.graduate.R;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;


public class MainActivity extends AppCompatActivity {
    //private FragmentTabHost tabhost;
    private ViewPager viewPager;
    private BottomNavigationBar Tab;
    private MainViewPageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initTabHost();
        initPage();
        initTab();
    }
    private void initPage(){

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new MainViewPageAdapter(getSupportFragmentManager(),MyContan.FRAGMENT_CLASS);
        viewPager.setAdapter(adapter);
        //关闭预加载，默认一次只加载一个fragmeent
        viewPager.setOffscreenPageLimit(1);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Tab.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initTab(){
        Tab = (BottomNavigationBar) findViewById(R.id.Tab);
        for (int i = 0; i < 5; i++) {
            Tab.addItem(new BottomNavigationItem(MyContan.TANHOST_IMAGE[i],MyContan.TABHOST_NAMES[i]));
        }
        Tab.initialise();
        Tab.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                //当Item被选中状态
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {
                //当Item不被选中
            }

            @Override
            public void onTabReselected(int position) {
                //当item再次被选中
            }
        });
    }
    /**
     * 初始化TabHost
     */
    /*private void initTabHost(){
        tabhost = (FragmentTabHost) findViewById(R.id.tabhost);
        //初始化fragmenttabhost
        tabhost.setup(this,getSupportFragmentManager(),R.id.fragment);

        tabhost.getTabWidget().setDividerDrawable(null);//去除分割线
        // 设置内容
        for (int i = 0; i < 5; i++) {
            TabHost.TabSpec tabSpec = tabhost.newTabSpec(i+"");
            View view = getLayoutInflater().inflate(R.layout.tabhost_item,null);
            ImageView iv_tabhost = (ImageView) view.findViewById(R.id.iv_tabhost);
            iv_tabhost.setImageResource(MyContan.TANHOST_IMAGE[i]);
            TextView tv_tabhost = (TextView) view.findViewById(R.id.tv_tabhost);
            tv_tabhost.setText(MyContan.TABHOST_NAMES[i]);
            tabSpec.setIndicator(view);
            //添加fragment
            tabhost.addTab(tabSpec,MyContan.FRAGMENT_CLASS[i],null);
        }
    }*/
}
