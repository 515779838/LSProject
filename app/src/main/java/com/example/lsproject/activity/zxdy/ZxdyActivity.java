package com.example.lsproject.activity.zxdy;

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
import com.example.lsproject.fragment.ZxdyFragment;
import com.hhkj.highschool.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 在线调研
 */
public class ZxdyActivity extends BaseActivity {
    private List<Fragment> list = new ArrayList<>();
    private ViewPagerAdapter adapter;
    private TabLayout mTabLayout;
    private ViewPager viewPager;
    private String[] arr = {"会议列表", "历史会议"};

    private String title = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxdy);
        initView();
    }

    private void initView() {
        setLeftBtn(true);
        title = getIntent().getStringExtra("title");
        setTextTitle(title);

        mTabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.addTab(mTabLayout.newTab().setText(arr[0]));
        mTabLayout.addTab(mTabLayout.newTab().setText(arr[1]));
        final ZxdyFragment y1 = new ZxdyFragment();
        y1.initData("0","","",title);
        final ZxdyFragment y2 = new ZxdyFragment();
        y1.initData("1","","",title);

        list.add(y1);
        list.add(y2);

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
