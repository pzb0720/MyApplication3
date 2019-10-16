package com.example.myapplication.ui.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mylibrary.util.NetworkConnectionUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;

import java.util.concurrent.atomic.AtomicBoolean;

import static com.scwang.smartrefresh.layout.internal.InternalClassics.ID_TEXT_TITLE;

public class MyClassicsWithFooterRefreshLayout extends SmartRefreshLayout {
    MyClassicsHeader mHeaderView;

    public MyClassicsWithFooterRefreshLayout(Context context) {
        this(context, null);
    }

    public MyClassicsWithFooterRefreshLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyClassicsWithFooterRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mHeaderView = new MyClassicsHeader(context);
        mHeaderView.setLayoutParams(layoutParams);
        addView(mHeaderView, 0);

        setRefreshFooter(new ClassicsFooter(context));
        final TextView tv = getLayout().findViewById(ID_TEXT_TITLE);
        final AtomicBoolean net = new AtomicBoolean(true);
        final String REFRESH_FOOT_PULLING = "上拉可以加载";//"下拉可以刷新";
        final String REFRESH_FOOT_LOADING = "正在加载...";//"正在加载...";
        final String REFRESH_FOOT_RELEASE = "释放立即刷新";
        final String REFRESH_FOOT_FINISH = "加载成功";//"刷新完成";
        final String REFRESH_FOOT_FAILED = "加载失败";//"刷新失败";

        setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
            @Override
            public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
                switch (newState) {
                    case PullUpToLoad: //下拉过程
                        tv.setText(REFRESH_FOOT_PULLING);
                        break;
                    case ReleaseToLoad: //松开刷新
                        tv.setText(REFRESH_FOOT_RELEASE);
                        break;
                    case Loading:
                    case LoadReleased:
                    case Refreshing: //loading中
                        tv.setText(REFRESH_FOOT_LOADING);
                        if (NetworkConnectionUtils.isNetworkConnected(getContext())) {
                            net.set(true);
                        } else {
                            net.set(false);
                        }
                        break;
                }
            }

            @Override
            public void onFooterFinish(RefreshFooter footer, boolean success) {
                super.onFooterFinish(footer, success);
                if (net.get() == false) {
                    tv.setText("请检查网络设置");
                } else if (net.get() == true && success) {
                    tv.setText(REFRESH_FOOT_FINISH);
                } else if (net.get() == true && !success) {
                    tv.setText(REFRESH_FOOT_FAILED);
                }
            }
        });

//        addView(mHeaderView, getChildCount() + 1);
    }


}
