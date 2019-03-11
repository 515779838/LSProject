package com.example.lsproject.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lsproject.R;
import com.example.lsproject.bean.CoursetableBean;

import java.util.List;

public class ScheduleAdapter extends BaseAdapter {

    private boolean isShowGradeClass = false;
    private List<CoursetableBean> stringList;
    private Context context;

    public ScheduleAdapter(boolean isShowGradeClass, List<CoursetableBean> stringList, Context context) {
        this.isShowGradeClass = isShowGradeClass;
        this.stringList = stringList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
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
                    R.layout.item_schedule, parent, false);
            holder.view_line = convertView.findViewById(R.id.view_line);
            holder.tv_schedule = (TextView) convertView.findViewById(R.id.tv_schedule);
            holder.tv_scheduleTo = (TextView) convertView.findViewById(R.id.tv_scheduleTo);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        if (position == (getCount() - 1)) {
            holder.view_line.setVisibility(View.GONE);
        } else {
            holder.view_line.setVisibility(View.VISIBLE);
        }
        if (stringList.get(position) != null) {
            holder.tv_schedule.setText(stringList.get(position).getSection());
            if (isShowGradeClass) {//教师
                if (stringList.get(position).getGradeClass().contains("无课")) {
                    holder.tv_scheduleTo.setTextColor(ContextCompat.getColor(context, android.R.color.darker_gray));
                } else {
                    holder.tv_scheduleTo.setTextColor(ContextCompat.getColor(context, android.R.color.black));
                }
                holder.tv_scheduleTo.setText(stringList.get(position).getGradeClass());
            } else {
                if (stringList.get(position).getTeaName().contains("无课")) {
                    holder.tv_scheduleTo.setTextColor(ContextCompat.getColor(context, android.R.color.darker_gray));
                } else {
                    holder.tv_scheduleTo.setTextColor(ContextCompat.getColor(context, android.R.color.black));
                }
                holder.tv_scheduleTo.setText(stringList.get(position).getTeaName());
            }
        }
        return convertView;
    }

    public class Holder {
        public View view_line;
        public TextView tv_schedule;
        public TextView tv_scheduleTo;
    }

}
