package com.example.lsproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lsproject.R;
import com.example.lsproject.bean.WdpxBean;

import java.util.List;

public class TbzyAdapter extends BaseAdapter {

    private List<WdpxBean> beans;
    private Context context;
    private String flag;

    public TbzyAdapter(List<WdpxBean> beans, Context context, String flag) {
        this.beans = beans;
        this.context = context;
        this.flag = flag;
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
                    R.layout.item_ykzy, parent, false);
//            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
//            holder.tv_year = (TextView) convertView.findViewById(R.id.tv_year);
            holder.ll_flag = convertView.findViewById(R.id.ll_flag);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }


        if (flag.equals("1")){
            holder.ll_flag.setVisibility(View.VISIBLE);
        }

//        holder.tv_name.setText(beans.get(position).getName());
//        holder.tv_year.setText(beans.get(position).getYear());
//
//        holder.tv_look.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
//        holder.tv_look.getPaint().setAntiAlias(true);//抗锯齿


        return convertView;
    }

    public class Holder {
        public TextView tv_name;
        public TextView tv_year;
        public LinearLayout ll_flag;
    }

}
