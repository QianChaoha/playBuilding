package com.example.playbuilding.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by cqian on 2017/5/4.
 */
public class MainViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<ImageView> mList;

    public List<ImageView> getmList() {
        return mList;
    }

    public MainViewPagerAdapter(Context context,List<ImageView> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view.equals(o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ViewPager viewPager= (ViewPager) container;
        ImageView imageView=mList.get(position);
//        ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(ScreenUtil.dip2px(mContext,30),ScreenUtil.dip2px(mContext,30));
        viewPager.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager= (ViewPager) container;
        viewPager.removeViewAt(position);
    }
}
