package com.example.lsproject.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.lsproject.R;
import com.example.lsproject.activity.ycpx.YcpxActivity;
import com.example.lsproject.activity.yxxx.YxxxActivity;
import com.example.lsproject.activity.zxzy.ZxzyActivity;
import com.example.lsproject.adapter.HomeAdapter;
import com.example.lsproject.bean.HomeBean;
import com.example.lsproject.view.SlideShowView;
import com.hhkj.highschool.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private List<HomeBean> homeModels;
    private SlideShowView slideShowView;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        setTextTitle(getString(R.string.app_name));

        setRightButton(true, R.mipmap.ic_launcher_round, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("zj", "setRightButton");
            }
        });

        setLeftButton(true, R.mipmap.ic_launcher_round, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("zj", "setLeftButton");
            }
        });

        slideShowView = findViewById(R.id.slideShowView);
        gridView = findViewById(R.id.gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (homeModels.get(position).getResourceId()) {
                    case "1":
                        intent = new Intent(MainActivity.this, YcpxActivity.class);
                        intent.putExtra("title",homeModels.get(position).getResourceName());
                        break;
                    case "2":
                        intent = new Intent(MainActivity.this, ZxzyActivity.class);
                        intent.putExtra("title",homeModels.get(position).getResourceName());
                        break;
                    case "3":
                        intent = new Intent(MainActivity.this, YxxxActivity.class);
                        intent.putExtra("title",homeModels.get(position).getResourceName());
                        break;

                    default:
                        Toast.makeText(MainActivity.this, "功能暂未开放，敬请期待", Toast.LENGTH_SHORT).show();
                        break;
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });

        // 轮播Banner
        slideShowView.setTimeInterval(5);
        int imgs[] = new int[3];
        imgs[0] = R.mipmap.baaner1;
        imgs[1] = R.mipmap.baaner2;
        imgs[2] = R.mipmap.baaner3;
        slideShowView.initUI(MainActivity.this, 2, imgs);

        initData();

    }

    private void initData() {
        homeModels = new ArrayList<>();
        HomeBean homeBean1 = new HomeBean("1","远程培训",""+R.mipmap.ic_launcher);
        HomeBean homeBean2 = new HomeBean("2","在线资源",""+R.mipmap.ic_launcher);
        HomeBean homeBean3 = new HomeBean("3","研修学习",""+R.mipmap.ic_launcher);

        homeModels.add(homeBean1);
        homeModels.add(homeBean2);
        homeModels.add(homeBean3);
        gridView.setAdapter(new HomeAdapter(homeModels,MainActivity.this));
    }
}
