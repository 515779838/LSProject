package com.example.lsproject.view;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.lsproject.R;


public class ListViewPopupWindow extends PopupWindow implements
        View.OnTouchListener,
        PopupWindow.OnDismissListener {

    public static ListViewPopupWindow newInstance(Activity activity, int resource, int width, int height,
                                                  boolean updateBackground, ListAdapter adapter,
                                                  AdapterView.OnItemClickListener listener) {
        //LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View contentView = LayoutInflater.from(activity).inflate(resource, null);
        ListViewPopupWindow popupWindow = new ListViewPopupWindow(activity, contentView, width, height, updateBackground, listener);

        popupWindow.setAdapter(adapter);
        return popupWindow;
    }

    // 当前窗口
    private Window mWindow;
    // 列表视图
    private ListView mListView;
    // 更新背景
    private boolean mUpdateBackground;

    public ListViewPopupWindow(Activity activity, View contentView, int width, int height, boolean updateBackground, AdapterView.OnItemClickListener listener) {
        super(contentView, width, height, true);

        mWindow = activity.getWindow();
        mUpdateBackground = updateBackground;

        setBackgroundDrawable(new BitmapDrawable());
        setTouchable(true);
        setOutsideTouchable(true);
        setTouchInterceptor(this);
        setOnDismissListener(this);

        // 加上这个PopupWindow中的ListView才可以接收点击事件
        //mPopupWindow.setFocusable(true);

        mListView = (ListView) contentView.findViewById(android.R.id.list);
        mListView.setOnItemClickListener(listener);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override
    public void onDismiss() {
        if (mUpdateBackground) {
            // 设置背景颜色变暗
            WindowManager.LayoutParams params = mWindow.getAttributes();
            params.alpha = 1.0f;
            mWindow.setAttributes(params);
        }
    }

    /**
     * 获取列表视图适配器
     *
     * @return 列表视图适配器
     */
    public ListAdapter getAdapter() {
        return mListView.getAdapter();
    }

    /**
     * 设置列表视图适配器
     *
     * @param adapter 列表视图适配器
     */
    public void setAdapter(ListAdapter adapter) {
        mListView.setAdapter(adapter);
    }

    /**
     * 显示窗口
     *
     * @param anchor 位置参考视图
     * @param xoff   水平偏移量
     * @param yoff   垂直偏移量
     */
    public void show(View anchor, int xoff, int yoff, boolean animate) {
        if (animate) {
            setAnimationStyle(R.style.Popup_Window);
        }
        showAsDropDown(anchor, xoff, yoff);

        if (mUpdateBackground) {
            // 设置背景颜色变暗
            WindowManager.LayoutParams params = mWindow.getAttributes();
            params.alpha = 0.3f;
            mWindow.setAttributes(params);
        }
    }
}