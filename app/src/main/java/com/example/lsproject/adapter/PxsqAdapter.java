package com.example.lsproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lsproject.R;
import com.example.lsproject.activity.ycpx.wdpx.WdpxDetailActivity;
import com.example.lsproject.bean.WdpxBean;

import java.util.List;

public class PxsqAdapter extends BaseAdapter {

    private List<WdpxBean> beans;
    private Context context;
    private String title;

    public PxsqAdapter(List<WdpxBean> beans, Context context, String title) {
        this.beans = beans;
        this.context = context;
        this.title = title;
    }

    @Override
    public int getCount() {
        return beans == null ? 0 : beans.size();
    }

    @Override
    public Object getItem(int position) {
        return beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_pxsq, parent, false);
//            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
//            holder.tv_year = (TextView) convertView.findViewById(R.id.tv_year);
            holder.tv_apply = (TextView) convertView.findViewById(R.id.tv_apply);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }



//        holder.tv_name.setText(beans.get(position).getName());
//        holder.tv_year.setText(beans.get(position).getYear());
//
//        holder.tv_look.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
//        holder.tv_look.getPaint().setAntiAlias(true);//抗锯齿
        holder.tv_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onApplyClick.setOnIsApply(beans.get(position).getId(), position);
            }
        });


        return convertView;
    }

    public class Holder {
        public TextView tv_name;
        public TextView tv_year;
        public TextView tv_apply;
    }


    OnApplyClick onApplyClick;

    public interface OnApplyClick {
        void setOnIsApply(String id, int position);
    }

    public void setOnIsApply(OnApplyClick onApplyClick) {
        this.onApplyClick = onApplyClick;
    }

}
