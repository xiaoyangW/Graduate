package com.arvin.graduate.Contans;

import com.arvin.graduate.Fragment.CategoryFragment;
import com.arvin.graduate.Fragment.HomeFragment;
import com.arvin.graduate.Fragment.MyFragment;
import com.arvin.graduate.Fragment.ParentingFragment;
import com.arvin.graduate.Fragment.ShopcartFragment;
import com.arvin.graduate.R;

/**
 * Created by acer1 on 2016/7/12.
 */

public class MyContan {
    public static String PIC = "http://10.10.10.121:8080/ECServer_D/";
    public static  String LOG = "wxy";
    public static final String  TAG_IMAGE_ID = "imageid";
    public static String ISFRISHRUN = "isFrishRun";
    /**
     * 引导界面
     */
    public static final int[] IMAGES={
            R.drawable.guid_page_iv,
            R.drawable.guid_page_iv2,
            R.drawable.guid_page_iv1
    };
    /**
     * Fragment界面数组
     */
    public static final Class[] FRAGMENT_CLASS={
            HomeFragment.class,
            CategoryFragment.class,
            ParentingFragment.class,
            ShopcartFragment.class,
            MyFragment.class
    };
    /**
     * 主页TabHost菜单名
     */
    public static final String[] TABHOST_NAMES = {
            "首页",
            "搜索",
            "品牌",
            "购物车",
            "更多"
    };
    /**
     * 主界面底菜单栏TabHost图片
     */
    public  static final int[] TANHOST_IMAGE = {
            R.drawable.home,
            R.drawable.category,
            R.drawable.parenting,
            R.drawable.shopcart,
            R.drawable.my
    };

}
