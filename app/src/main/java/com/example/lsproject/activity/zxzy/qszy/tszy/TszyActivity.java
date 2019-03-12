package com.example.lsproject.activity.zxzy.qszy.tszy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.lsproject.R;
import com.example.lsproject.activity.zxzy.qszy.tbzy.Search2Activity;
import com.example.lsproject.fragment.TszyFragment;
import com.hhkj.highschool.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 通识资源
 */
public class TszyActivity extends BaseActivity {

    private List<Fragment> list = new ArrayList<>();
    private ViewPagerAdapter adapter;
    private TabLayout mTabLayout;
    private ViewPager viewPager;
    private String[] arr = {"科学实验室", "动画字库","幼儿资源"};
    private String title = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tszy);

        setLeftBtn(true);
        title = getIntent().getStringExtra("title");
        setTextTitle(title);

        setRightBtn(true, "搜索", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TszyActivity.this, Search2Activity.class);
                intent.putExtra("title",title);
                intent.putExtra("flag","tszy");
                startActivity(intent);
            }
        });
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
        final TszyFragment b1 = new TszyFragment();
        b1.initData("0","","",title);
        final TszyFragment b2 = new TszyFragment();
        b2.initData("1","","",title);
        final TszyFragment b3 = new TszyFragment();
        b3.initData("2","","",title);

        list.add(b1);
        list.add(b2);
        list.add(b3);
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
