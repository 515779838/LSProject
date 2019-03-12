package com.example.lsproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lsproject.R;
import com.example.lsproject.adapter.ZxdyAdapter;
import com.example.lsproject.base.BaseFragment;
import com.example.lsproject.bean.WdpxBean;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZxdyFragment extends BaseFragment {
    private PullToRefreshListView pullToRefreshListView;
    private ZxdyAdapter adapter;

    private String lbId= "";
    private String flId= "";
    private String index= "";
    private String title= "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_zxdy, container, false);
        initView();
        return mView;
    }

    private void initView() {
        pullToRefreshListView = mView.findViewById(R.id.pullToRefreshListView);
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.DISABLED);
        net_getData();
    }

    public void initData(String index, String lbId, String flId, String title) {
        this.index = index;
        this.lbId = lbId;
        this.flId = flId;
        this.title = title;
    }

    private void net_getData() {

        setData();
//        Map map = new HashMap<String, String>();
//        if (getActivity() == null){
//            Log.e("zj", "getActivity= ");
//
//            return;
//        }
//        if ("".equals(stuId) || "".equals(termId) || "".equals(ecId)) {
//            return;
//        }
//        map.put("stuId", stuId);
//        map.put("ecId", ecId);
//        map.put("termId", termId);
//
//
//        NetTools.net(map,new Urls().history_detail_get_card, getActivity(), new NetTools.MyCallBack() {
//            @Override
//            public void getData(BaseBean response) {
//                Log.e("zj", "history_detail_get_card 111111= " + response.getData());
//
//                ArrayList<CardDetailBean> list = new Gson().fromJson(response.getData(), new TypeToken<List<CardDetailBean>>() {}.getType());
//                cardListBeanList.addAll(list);
//
//                setData();
//            }
//        });

    }

    private void setData() {
//        setListToastView(cardListBeanList.size(), "暂无数据", R.mipmap.ic_no_data);
//
//        adapter = new GetCardDetailAdapter(getActivity(), cardListBeanList,"1");
//        pullToRefreshListView.setAdapter(adapter);


        List pxjhBeanList = new ArrayList<WdpxBean>();

        WdpxBean homeBean1 = new WdpxBean("1", "2018年第四季度", "2018年");


        pxjhBeanList.add(homeBean1);



        if (adapter == null){
            adapter = new ZxdyAdapter(pxjhBeanList,getActivity(),"");
            pullToRefreshListView.setAdapter(adapter);
        }else{
            adapter.notifyDataSetChanged();
        }


//        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getActivity(), BdzyDetailActivity.class);
//                intent.putExtra("title",title);
//                getActivity().startActivity(intent);
//            }
//        });
    }



}
