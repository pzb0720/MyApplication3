package com.example.myapplication.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.myapplication.R;
import com.example.myapplication.adapter.HotAdapter;
import com.example.myapplication.mvp.contract.HotContract;
import com.example.myapplication.mvp.model.bean.Friend;
import com.example.myapplication.mvp.presenter.home.HotPresenter;
import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.activity.BaseMVPActivity;
import com.example.mylibrary.util.StatusBarUtils;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/12/11 0011.
 */

public class HotActivity extends BaseMVPActivity<HotContract.HotPresenter> implements HotContract.IHotActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rv_hot)
    RecyclerView rvHot;

    HotAdapter hotAdapter;

    @Override
    protected void initView(Bundle savedInstanceState) {
        initToolBar(toolbar, "常用网站");
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        StatusBarUtils.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
        hotAdapter = new HotAdapter(null);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
        rvHot.setLayoutManager(flexboxLayoutManager);
        mPresenter.loadLatestList();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hot;
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return HotPresenter.newInstance();
    }

    @Override
    public void updateContentList(List list) {
        Log.i("哇哈哈", list.size() + "list,size");

        initRecyclerView(list);

    }

    private void initRecyclerView(List<Friend> list) {

        hotAdapter = new HotAdapter(R.layout.item_hot, list);
        hotAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.OnItemClick(position, (Friend) adapter.getItem(position));
            }
        });
        rvHot.setAdapter(hotAdapter);
    }

    @Override
    public void itemNotifyChanged(int id) {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showLoadMoreError() {

    }

    @Override
    public void showNoMoreData() {
//            hotAdapter.setEmptyView();

    }
}
