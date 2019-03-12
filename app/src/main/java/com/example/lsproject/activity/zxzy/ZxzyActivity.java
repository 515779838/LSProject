package com.example.lsproject.activity.zxzy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.lsproject.R;
import com.example.lsproject.activity.zxzy.bdzy.BdzyActivity;
import com.example.lsproject.activity.zxzy.qszy.QszyActivity;
import com.example.lsproject.activity.zxzy.ykzy.YkzyActivity;
import com.example.lsproject.adapter.HomeAdapter;
import com.example.lsproject.bean.HomeBean;
import com.hhkj.highschool.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class ZxzyActivity extends BaseActivity {
    private List<HomeBean> homeModels;

    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxzy);
        initView();
    }

    private void initView() {
        setLeftBtn(true);
        setTextTitle(getIntent().getStringExtra("title"));

        gridView = findViewById(R.id.gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (homeModels.get(position).getId()) {
                    case "1"://本地资源
                        intent = new Intent(ZxzyActivity.this, BdzyActivity.class);
                        intent.putExtra("title", homeModels.get(position).getName());
                        break;
                    case "2"://优课资源
                        intent = new Intent(ZxzyActivity.this, YkzyActivity.class);
                        intent.putExtra("title",homeModels.get(position).getName());
                        break;
                    case "3"://全市资源
                        intent = new Intent(ZxzyActivity.this, QszyActivity.class);
                        intent.putExtra("title",homeModels.get(position).getName());
                        break;

                    default:
                        Toast.makeText(ZxzyActivity.this, "功能暂未开放，敬请期待", Toast.LENGTH_SHORT).show();
                        break;
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
        initData();
    }

    private void initData() {
        homeModels = new ArrayList<>();
        HomeBean homeBean1 = new HomeBean("1", "本地资源", "" + R.mipmap.ic_launcher);
        HomeBean homeBean2 = new HomeBean("2", "优课资源", "" + R.mipmap.ic_launcher);
        HomeBean homeBean3 = new HomeBean("3", "全市资源", "" + R.mipmap.ic_launcher);


        homeModels.add(homeBean1);
        homeModels.add(homeBean2);
        homeModels.add(homeBean3);

        gridView.setAdapter(new HomeAdapter(homeModels, ZxzyActivity.this));
    }
}
