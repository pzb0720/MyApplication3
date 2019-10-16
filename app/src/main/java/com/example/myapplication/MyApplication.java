package com.example.myapplication;


import android.content.Context;
import android.support.annotation.NonNull;

import com.example.mylibrary.BaseApplication;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import org.litepal.LitePal;

public class MyApplication extends BaseApplication {
    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
//                return new MaterialHeader(getContext()).setColorSchemeResources(R.color.md_red_500, R.color.md_green_500, R.color.md_blue_500);
                ClassicsHeader classicsHeader = new ClassicsHeader(getContext());
                return new ClassicsHeader(getContext());
            }
        });

        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new ClassicsFooter(getContext());
            }
        });
    }


    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(getApplicationContext());


    }


}
