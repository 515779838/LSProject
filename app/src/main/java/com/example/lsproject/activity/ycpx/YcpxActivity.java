package com.example.lsproject.activity.ycpx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.lsproject.R;
import com.example.lsproject.activity.ycpx.dcwj.DcwjActivity;
import com.example.lsproject.activity.ycpx.pxjh.PxjhActivity;
import com.example.lsproject.activity.ycpx.pxsq.PxsqActivity;
import com.example.lsproject.activity.ycpx.wdpx.WdpxActivity;
import com.example.lsproject.activity.ycpx.xxda.XxdaActivity;
import com.example.lsproject.activity.ycpx.xxpxcx.XxpxcxActivity;
import com.example.lsproject.adapter.HomeAdapter;
import com.example.lsproject.bean.HomeBean;
import com.hhkj.highschool.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 远程培训
 */
public class YcpxActivity extends BaseActivity {
    private List<HomeBean> homeModels;

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ycpx);
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
                    case "1"://培训计划
                        intent = new Intent(YcpxActivity.this, PxjhActivity.class);
                        intent.putExtra("title", homeModels.get(position).getName());
                        break;
                    case "2"://我的培训
                        intent = new Intent(YcpxActivity.this, WdpxActivity.class);
                        intent.putExtra("title",homeModels.get(position).getName());
                        break;
                    case "3"://培训申请
                        intent = new Intent(YcpxActivity.this, PxsqActivity.class);
                        intent.putExtra("title",homeModels.get(position).getName());
                        break;
                    case "4"://调查问卷
                        intent = new Intent(YcpxActivity.this, DcwjActivity.class);
                        intent.putExtra("title",homeModels.get(position).getName());
                        break;
                    case "5"://学习档案
                        intent = new Intent(YcpxActivity.this, XxdaActivity.class);
                        intent.putExtra("title",homeModels.get(position).getName());
                        break;
                    case "6"://线下培训查询
                        intent = new Intent(YcpxActivity.this, XxpxcxActivity.class);
                        intent.putExtra("title",homeModels.get(position).getName());
                        break;
                    default:
                        Toast.makeText(YcpxActivity.this, "功能暂未开放，敬请期待", Toast.LENGTH_SHORT).show();
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
        HomeBean homeBean1 = new HomeBean("1", "培训计划", "" + R.mipmap.ic_launcher);
        HomeBean homeBean2 = new HomeBean("2", "我的培训", "" + R.mipmap.ic_launcher);
        HomeBean homeBean3 = new HomeBean("3", "培训申请", "" + R.mipmap.ic_launcher);
        HomeBean homeBean4 = new HomeBean("4", "调查问卷", "" + R.mipmap.ic_launcher);
        HomeBean homeBean5 = new HomeBean("5", "学习档案", "" + R.mipmap.ic_launcher);
        HomeBean homeBean6 = new HomeBean("6", "线下培训查询", "" + R.mipmap.ic_launcher);

        homeModels.add(homeBean1);
        homeModels.add(homeBean2);
        homeModels.add(homeBean3);
//        homeModels.add(homeBean4);
        homeModels.add(homeBean5);
        homeModels.add(homeBean6);
        gridView.setAdapter(new HomeAdapter(homeModels, YcpxActivity.this));
    }
}
