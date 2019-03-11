package com.example.lsproject.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lsproject.R;
import com.example.lsproject.bean.HomeBean;
import com.example.lsproject.bean.PxjhBean;
import com.hhkj.highschool.base.BaseActivity;

import java.util.List;

public class PxjhAdapter extends BaseAdapter {

    private List<PxjhBean> beans;
    private Context context;

    public PxjhAdapter(List<PxjhBean> beans, Context context) {
        this.beans = beans;
        this.context = context;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_pxjh, parent, false);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_year = (TextView) convertView.findViewById(R.id.tv_year);
            holder.tv_look = (TextView) convertView.findViewById(R.id.tv_look);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }



        holder.tv_name.setText(beans.get(position).getName());
        holder.tv_year.setText(beans.get(position).getYear());

        holder.tv_look.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        holder.tv_look.getPaint().setAntiAlias(true);//抗锯齿
        return convertView;
    }

    public class Holder {
        public TextView tv_name;
        public TextView tv_year;
        public TextView tv_look;
    }

}
