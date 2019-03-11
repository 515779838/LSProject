package com.example.lsproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lsproject.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10 0010.
 */

public class MenuAdapter extends BaseAdapter {

    private List<String> items;
    private Context context;

    public MenuAdapter(List<String> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.list_item_menu, parent, false);
            textView = (TextView) convertView.findViewById(R.id.title_text);
            convertView.setTag(textView);
        } else {
            textView = (TextView) convertView.getTag();
        }
        textView.setText(items.get(position));
        return convertView;
    }
}
