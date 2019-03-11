package com.example.lsproject.activity.yxxx;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lsproject.R;
import com.example.lsproject.fragment.YxxxFragment;
import com.hhkj.highschool.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class YxxxActivity extends BaseActivity {
    private List<Fragment> list = new ArrayList<>();
    private ViewPagerAdapter adapter;
    private TabLayout mTabLayout;
    private ViewPager viewPager;
    private String[] arr = {"全部", "正在进行","即将开始", "已结束"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yxxx);
        initView();
    }

    private void initView() {

        mTabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.addTab(mTabLayout.newTab().setText(arr[0]));
        mTabLayout.addTab(mTabLayout.newTab().setText(arr[1]));
        mTabLayout.addTab(mTabLayout.newTab().setText(arr[2]));
        mTabLayout.addTab(mTabLayout.newTab().setText(arr[3]));
        final YxxxFragment y1 = new YxxxFragment();
        y1.initData("0","","");
        final YxxxFragment y2 = new YxxxFragment();
        y1.initData("1","","");
        final YxxxFragment y3 = new YxxxFragment();
        y1.initData("2","","");
        final YxxxFragment y4 = new YxxxFragment();
        y1.initData("3","","");
        list.add(y1);
        list.add(y2);
        list.add(y3);
        list.add(y4);
        adapter = new ViewPagerAdapter(this.getSupportFragmentManager(), this, list, arr);
        viewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(2);//预加载



    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {

        private String[] tabTitles;
        private List<Fragment> fragmentList;

        public ViewPagerAdapter(FragmentManager fm, Context context, List<Fragment> fragmentList, String[] arr) {
            super(fm);
            this.tabTitles = arr;
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
