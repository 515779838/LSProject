package com.example.lsproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lsproject.R;
import com.example.lsproject.activity.ycpx.wdpx.LessionEvaActivity;
import com.example.lsproject.activity.ycpx.wdpx.LessonListActivity;
import com.example.lsproject.bean.WdpxBean;

import java.util.List;

public class LessionEvaAdapter extends BaseAdapter {

    private List<WdpxBean> beans;
    private Context context;
    private String title;

    public LessionEvaAdapter(List<WdpxBean> beans, Context context, String title) {
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
                    R.layout.item_lession_eva, parent, false);
//            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
//            holder.tv_year = (TextView) convertView.findViewById(R.id.tv_year);
            holder.tv_edit = (TextView) convertView.findViewById(R.id.tv_edit);
            holder.tv_delete = (TextView) convertView.findViewById(R.id.tv_delete);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }


        //进入课程
        holder.tv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, LessonListActivity.class);
                intent.putExtra("id",beans.get(position).getId());
                intent.putExtra("title",title);
                context.startActivity(intent);
            }
        });
        //课程评价
        holder.tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteClick.setOnIsDelete(beans.get(position).getId(), position);
            }
        });
        return convertView;
    }

    public class Holder {
        public TextView tv_name;
        public TextView tv_year;
        public TextView tv_look;
        public TextView tv_edit;
        public TextView tv_delete;
    }


    OnDeleteClick onDeleteClick;

    public interface OnDeleteClick {
        void setOnIsDelete(String id, int position);
    }

    public void setOnIsDelete(OnDeleteClick onDeleteClick) {
        this.onDeleteClick = onDeleteClick;
    }
}
