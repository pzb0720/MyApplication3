package com.example.wanandroid.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class MyClassicsRefreshLayout extends SmartRefreshLayout {
    MyClassicsHeader mHeaderView = null;

    public MyClassicsRefreshLayout(Context context) {
        this(context, null);
    }

    public MyClassicsRefreshLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyClassicsRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mHeaderView = new MyClassicsHeader(context);
        mHeaderView.setLayoutParams(layoutParams);
        addView(mHeaderView, 0);

//        addView(mHeaderView, getChildCount() + 1);
    }

}
