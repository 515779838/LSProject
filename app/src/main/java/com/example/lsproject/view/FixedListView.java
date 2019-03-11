package com.example.lsproject.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 无滚动条的 ListView 控件
 */
public class FixedListView extends ListView {

    public FixedListView(Context context) {
        super(context);
    }

    public FixedListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FixedListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 设置控件高度来禁止出现滚动条
     */
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    /**
     * 通过重新dispatchTouchEvent方法来禁止滑动
     */
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        if(event.getAction() == MotionEvent.ACTION_MOVE){
//            return true;    // 禁止 Gridview 进行滑动
//        }
//        return super.dispatchTouchEvent(event);
//    }
}
