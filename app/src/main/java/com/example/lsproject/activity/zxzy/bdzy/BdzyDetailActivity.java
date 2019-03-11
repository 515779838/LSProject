package com.example.lsproject.activity.zxzy.bdzy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lsproject.R;
import com.hhkj.highschool.base.BaseActivity;

public class BdzyDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdzy_detail);
        setLeftBtn(true);
        setTextTitle(getIntent().getStringExtra("title"));
    }
}
