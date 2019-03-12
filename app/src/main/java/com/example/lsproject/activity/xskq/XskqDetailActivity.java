package com.example.lsproject.activity.xskq;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.lsproject.R;
import com.example.lsproject.adapter.XskqDetailAdapter;
import com.example.lsproject.bean.StuBean;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.hhkj.highschool.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class XskqDetailActivity extends BaseActivity {

    private PullToRefreshListView mListView;
    private List<StuBean> models;
    private CheckBox mMainCkb;
    private XskqDetailAdapter mMyAdapter;
    //监听来源
    public boolean mIsFromItem = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xskq_detail);

        initView();
        initData();
        initViewOper();

    }

    /**
     * view初始化
     */
    private void initView() {

        mListView = findViewById(R.id.pullToRefreshListView);
        mMainCkb = findViewById(R.id.checkBox);
    }

    /**
     * 数据加载
     */
    private void initData() {
        //模拟数据
        models = new ArrayList<>();
        StuBean model;
        for (int i = 0; i < 15; i++) {
            model = new StuBean();
            model.setId(i + "******");
            model.setCheck(false);
            models.add(model);
        }
    }

    /**
     * 数据绑定
     */
    private void initViewOper() {
        mMyAdapter = new XskqDetailAdapter(models, this, new AllCheckListener() {

            @Override
            public void onCheckedChanged(boolean b) {
                //根据不同的情况对maincheckbox做处理
                if (!b && !mMainCkb.isChecked()) {
                    return;
                } else if (!b && mMainCkb.isChecked()) {
                    mIsFromItem = true;
                    mMainCkb.setChecked(false);
                } else if (b) {
                    mIsFromItem = true;
                    mMainCkb.setChecked(true);
                }
            }
        });
        mListView.setAdapter(mMyAdapter);
        //全选的点击监听
        mMainCkb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //当监听来源为点击item改变maincbk状态时不在监听改变，防止死循环
                if (mIsFromItem) {
                    mIsFromItem = false;
                    Log.e("mainCheckBox", "此时我不可以触发");
                    return;
                }

                //改变数据
                for (StuBean model : models) {
                    model.setCheck(b);
                }
                //刷新listview
                mMyAdapter.notifyDataSetChanged();
            }
        });

    }
    //对item导致maincheckbox改变做监听
  public   interface AllCheckListener {
        void onCheckedChanged(boolean b);
    }

}
