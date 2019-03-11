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
import com.example.lsproject.activity.ycpx.wdpx.LessonListActivity;
import com.example.lsproject.activity.ycpx.wdpx.WdpxDetailActivity;
import com.example.lsproject.bean.WdpxBean;

import java.util.List;

public class WdpxDetailAdapter extends BaseAdapter {

    private List<WdpxBean> beans;
    private Context context;
    private String title;

    public WdpxDetailAdapter(List<WdpxBean> beans, Context context, String title) {
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
                    R.layout.item_wdpx_detail, parent, false);
//            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
//            holder.tv_year = (TextView) convertView.findViewById(R.id.tv_year);
            holder.tv_jrkc = (TextView) convertView.findViewById(R.id.tv_jrkc);
            holder.tv_kcpj = (TextView) convertView.findViewById(R.id.tv_kcpj);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }


        //进入课程
        holder.tv_jrkc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, LessonListActivity.class);
                intent.putExtra("id",beans.get(position).getId());
                intent.putExtra("title",title);
                context.startActivity(intent);
            }
        });
        //课程评价
        holder.tv_kcpj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, LessonListActivity.class);
                intent.putExtra("id",beans.get(position).getId());
                intent.putExtra("title",title);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    public class Holder {
        public TextView tv_name;
        public TextView tv_year;
        public TextView tv_look;
        public TextView tv_jrkc;
        public TextView tv_kcpj;
    }

}
