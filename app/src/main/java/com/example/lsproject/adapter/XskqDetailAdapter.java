package com.example.lsproject.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.lsproject.R;
import com.example.lsproject.activity.xskq.XskqDetailActivity;
import com.example.lsproject.bean.StuBean;

import java.util.List;

public class XskqDetailAdapter extends BaseAdapter {
    private List<StuBean> data;
    private Context context;
    private XskqDetailActivity.AllCheckListener allCheckListener;

    public XskqDetailAdapter(List<StuBean> data, Context context, XskqDetailActivity.AllCheckListener allCheckListener) {
        this.data = data;
        this.context = context;
        this.allCheckListener = allCheckListener;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHoder hd;
        if (view == null) {
            hd = new ViewHoder();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.item_xskq_detail, null);
            hd.textView = (TextView) view.findViewById(R.id.tv_name);
            hd.checkBox = (CheckBox) view.findViewById(R.id.ckb);
            view.setTag(hd);
        }
        StuBean mModel = data.get(i);
        hd = (ViewHoder) view.getTag();
        hd.textView.setText(mModel.getName());

        Log.e("zj myadapter", mModel.getName() + "------" + mModel.isCheck());
        final ViewHoder hdFinal = hd;
        hd.checkBox.setChecked(mModel.isCheck());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox checkBox = hdFinal.checkBox;
                if (checkBox.isChecked()) {
                    checkBox.setChecked(false);
                    data.get(i).setCheck(false);
                } else {
                    checkBox.setChecked(true);
                    data.get(i).setCheck(true);
                }
                //监听每个item，若所有checkbox都为选中状态则更改main的全选checkbox状态
                for (StuBean model : data) {
                    if (!model.isCheck()) {
                        allCheckListener.onCheckedChanged(false);
                        return;
                    }
                }
                allCheckListener.onCheckedChanged(true);


            }
        });


        return view;
    }

    class ViewHoder {
        TextView textView;
        CheckBox checkBox;
    }

}

