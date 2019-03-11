package com.example.lsproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lsproject.R;
import com.example.lsproject.bean.HomeBean;
import com.hhkj.highschool.base.BaseActivity;

import java.util.List;

/**
 * Created by caoyingfu on 2017/8/16.
 */

public class HomeAdapter extends BaseAdapter {

    private List<HomeBean> homeModels;
    private Context context;

    public HomeAdapter(List<HomeBean> homeModels, Context context) {
        this.homeModels = homeModels;
        this.context = context;
    }

    @Override
    public int getCount() {
        return homeModels == null ? 0 : homeModels.size();
    }

    @Override
    public Object getItem(int position) {
        return homeModels.get(position);
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
                    R.layout.item_home, parent, false);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        if (homeModels != null && homeModels.get(position) != null && homeModels.get(position).getIcon() != null) {
            if (homeModels.get(position).getIcon().startsWith("http")) {
                Glide.with(context).load(((BaseActivity) context).getImgPrePath() + homeModels.get(position).getIcon()).into(holder.imageView);
            } else {
                Glide.with(context).load(Integer.valueOf(homeModels.get(position).getIcon())).into(holder.imageView);
            }
        }
        String name = homeModels.get(position).getResourceName();
        if (name.length() < 6) {

        } else if (name.length() == 6) {
            name = name.substring(0, 3) + "\n" + name.substring(3, 6);
        } else if (name.length() > 6) {
            name = name.substring(0, 4) + "\n" + name.substring(4, name.length());
        }
        holder.textView.setText(name);
        return convertView;
    }

    public class Holder {
        public ImageView imageView;
        public TextView textView;
    }

}
