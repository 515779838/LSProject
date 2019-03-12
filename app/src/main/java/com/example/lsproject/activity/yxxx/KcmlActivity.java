package com.example.lsproject.activity.yxxx;

import android.os.Bundle;

import com.example.lsproject.R;
import com.hhkj.highschool.base.BaseActivity;

/**
 * 课程目录
 */
public class KcmlActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kcml);
        setLeftBtn(true);
        setTextTitle(getIntent().getStringExtra("title"));
    }
}
