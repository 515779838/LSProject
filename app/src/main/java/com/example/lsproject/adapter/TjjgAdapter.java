package com.example.lsproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lsproject.R;
import com.example.lsproject.activity.ycpx.dcwj.TjjgActivity;
import com.example.lsproject.bean.PxjhBean;

import java.util.List;

public class TjjgAdapter extends BaseAdapter {

    private List<PxjhBean> beans;
    private Context context;

    public TjjgAdapter(List<PxjhBean> beans, Context context) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_dcwj, parent, false);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_year = (TextView) convertView.findViewById(R.id.tv_year);
            holder.tv_results = (TextView) convertView.findViewById(R.id.tv_results);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }



        holder.tv_name.setText(beans.get(position).getName());
        holder.tv_year.setText(beans.get(position).getYear());

        holder.tv_results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //统计结果
                Intent intent = new Intent(context, TjjgActivity.class);
                intent.putExtra("id",beans.get(position).getId());
                context.startActivity(intent);
            }
        });


        holder.tv_results.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        holder.tv_results.getPaint().setAntiAlias(true);//抗锯齿
        return convertView;
    }

    public class Holder {
        public TextView tv_name;
        public TextView tv_year;
        public TextView tv_results;
    }

}
