package com.example.lsproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.cyf.nfcproject.bean.BaseBean;
import com.cyf.nfcproject.tools.SPTools;
import com.example.lsproject.R;
import com.example.lsproject.adapter.ScheduleAdapter;
import com.example.lsproject.bean.CoursetableBean;
import com.example.lsproject.constant.Constant;
import com.example.lsproject.tools.NetTools;
import com.example.lsproject.url.Urls;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyScheduleFragment extends Fragment {

    private TextView tv_no_data;
    private PullToRefreshListView pullToRefreshListView;
    private ScheduleAdapter scheduleAdapter;

    private List<CoursetableBean> coursetableBeanList;

    private String week = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_my_schedule, container, false);
        initView(mView);
        return mView;
    }

    private void initView(View mView) {
        tv_no_data = mView.findViewById(R.id.tv_no_data);
        pullToRefreshListView = mView.findViewById(R.id.pullToRefreshListView);
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.DISABLED);
        coursetableBeanList = new ArrayList<>();
    }

    private void setData() {


        if (scheduleAdapter == null) {
            scheduleAdapter = new ScheduleAdapter(true, coursetableBeanList, getActivity());
//            if (SPTools.INSTANCE.get(getActivity(), Constant.USERTYPE, "").equals("1")) {
//                scheduleAdapter = new ScheduleAdapter(true, coursetableBeanList, getActivity());
//            } else {
//                scheduleAdapter = new ScheduleAdapter(false, coursetableBeanList, getActivity());
//            }
            pullToRefreshListView.setAdapter(scheduleAdapter);
        } else {
            scheduleAdapter.notifyDataSetChanged();
        }
        if (coursetableBeanList == null || (coursetableBeanList != null && coursetableBeanList.size() == 0)) {
            tv_no_data.setVisibility(View.VISIBLE);
            pullToRefreshListView.setVisibility(View.GONE);
        } else {
            tv_no_data.setVisibility(View.GONE);
            pullToRefreshListView.setVisibility(View.VISIBLE);
        }

        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }


    // 教师（家长）我的课表
    public void initData(String week) {
        this.week = week;
    }

    private void net_Coursetable() {
        Map map = new HashMap<String, String>();
        String url = "";
//        if ("1".equals(SPTools.INSTANCE.get(getActivity(), Constant.USERTYPE, ""))) {
//            map.put("schId", SPTools.INSTANCE.get(getActivity(), Constant.SCHOOLID, ""));
//            map.put("week", week);
//            map.put("userId", SPTools.INSTANCE.get(getActivity(), Constant.ID, ""));
//            url = new Urls().course_teacher;
//        } else {
//            map.put("schId", SPTools.INSTANCE.get(getActivity(), Constant.SCHOOLID, ""));
//            map.put("week", week);
//            map.put("classId", SPTools.INSTANCE.get(getActivity(), Constant.CLASSID, ""));
//            url = new Urls().course_student;
//        }
        NetTools.net(map, url, getActivity(), new NetTools.MyCallBack() {
            @Override
            public void getData(BaseBean response) {
                coursetableBeanList = new Gson().fromJson(response.getData(), new TypeToken<List<CoursetableBean>>() {
                }.getType());
                setData();
            }
        }, "正在加载...", false, false);
    }

}
