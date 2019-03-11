package com.example.lsproject.activity.zxzy.bdzy;

import android.os.Bundle;

import com.example.lsproject.R;
import com.example.lsproject.adapter.BdzyAdapter;
import com.hhkj.highschool.base.BaseActivity;

public class SearchActivity extends BaseActivity {
    private BdzyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
}
