package com.example.mylibrary.base.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mylibrary.R;
import com.example.mylibrary.base.ui.BasePresenter;

/**
 * Created by Administrator on 2018/11/26 0026.
 */

public abstract class BaseRecyclerFragment<P extends BasePresenter> extends BaseMVPFragment<P> {
    /**
     * 网络异常的view
     */
    protected View errorView;
    /**
     * 空内容的view
     */
    protected View emptyView;
    /**
     * 加载内容的view
     */
    protected View loadingView;

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        showLoading();
    }

    protected abstract void showLoading();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        errorView = inflater.inflate(R.layout.view_network_error, container, false);
        emptyView = inflater.inflate(R.layout.view_empty, container, false);
        loadingView = inflater.inflate(R.layout.view_loading, container, false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();
                onErrorViewClick(v);
            }
        });
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract void onErrorViewClick(View v);
}
