package com.example.wanandroid.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.wanandroid.R;
import com.example.wanandroid.mvp.contract.UserCoinListContract;
import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.activity.BaseMVPActivity;

import java.util.List;

public class UserCoinListActivity extends BaseMVPActivity<UserCoinListContract.UserCoinListPresenter> implements UserCoinListContract.IUserCoinListView {
    @Override
    public void updateContentList(List list) {

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

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_coin_list;
    }
}
