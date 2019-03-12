package com.example.lsproject.activity.zxzy.qszy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.lsproject.R;
import com.example.lsproject.activity.zxzy.ZxzyActivity;
import com.example.lsproject.activity.zxzy.bdzy.BdzyActivity;
import com.example.lsproject.activity.zxzy.qszy.tbzy.TbzyActivity;
import com.example.lsproject.activity.zxzy.qszy.tszy.TszyActivity;
import com.example.lsproject.activity.zxzy.qszy.yxsfk.YxsfkActivity;
import com.example.lsproject.activity.zxzy.ykzy.YkzyActivity;
import com.example.lsproject.adapter.HomeAdapter;
import com.example.lsproject.bean.HomeBean;
import com.hhkj.highschool.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 全市资源
 */
public class QszyActivity extends BaseActivity {
    private List<HomeBean> homeModels;

    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qszy);
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
                    case "1"://同步资源
                        intent = new Intent(QszyActivity.this, TbzyActivity.class);
                        intent.putExtra("title", homeModels.get(position).getName());
                        break;
                    case "2"://通识资源
                        intent = new Intent(QszyActivity.this, TszyActivity.class);
                        intent.putExtra("title",homeModels.get(position).getName());
                        break;
                    case "3"://优秀示范课
                        intent = new Intent(QszyActivity.this, YxsfkActivity.class);
                        intent.putExtra("title",homeModels.get(position).getName());
                        break;

                    default:
                        Toast.makeText(QszyActivity.this, "功能暂未开放，敬请期待", Toast.LENGTH_SHORT).show();
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
        HomeBean homeBean1 = new HomeBean("1", "同步资源", "" + R.mipmap.ic_launcher);
        HomeBean homeBean2 = new HomeBean("2", "通识资源", "" + R.mipmap.ic_launcher);
        HomeBean homeBean3 = new HomeBean("3", "优秀示范课", "" + R.mipmap.ic_launcher);


        homeModels.add(homeBean1);
        homeModels.add(homeBean2);
        homeModels.add(homeBean3);

        gridView.setAdapter(new HomeAdapter(homeModels, QszyActivity.this));
    }
}
