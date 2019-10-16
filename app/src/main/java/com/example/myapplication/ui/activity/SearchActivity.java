package com.example.myapplication.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.myapplication.R;
import com.example.myapplication.adapter.HotAdapter;
import com.example.myapplication.mvp.contract.SearchContract;
import com.example.myapplication.mvp.model.bean.Friend;
import com.example.myapplication.mvp.presenter.home.SearchPresenter;
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

public class SearchActivity extends BaseMVPActivity<SearchContract.SearchPresenter> implements SearchContract.ISearchView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.et_toolbar)
    EditText edToolbar;

    @BindView(R.id.rv_search)
    RecyclerView rvSearch;

    HotAdapter hotAdapter;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(com.example.mylibrary.R.mipmap.ic_arrow_back_white);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressedSupport();
            }
        });
        StatusBarUtils.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary));

        hotAdapter = new HotAdapter(null);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
        rvSearch.setLayoutManager(flexboxLayoutManager);

        toolbar.inflateMenu(R.menu.search);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_main_search:
                        String str = edToolbar.getText().toString().trim();
                        if (!TextUtils.isEmpty(str)) {
                            mPresenter.onMenuItemClick(str);
                        }
                        break;
                }
                return false;
            }
        });
        mPresenter.loadLatestList();


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return SearchPresenter.newInstance();
    }

    @Override
    public void updateContentList(List list) {
        Log.i("哇哈哈", "list.size()");
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
        rvSearch.setAdapter(hotAdapter);
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

    }
}
