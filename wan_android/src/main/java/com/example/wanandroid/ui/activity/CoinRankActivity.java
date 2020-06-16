package com.example.wanandroid.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.wanandroid.R;
import com.example.wanandroid.adapter.CoinRankAdapter;
import com.example.wanandroid.mvp.contract.UserCoinContract;
import com.example.wanandroid.mvp.model.bean.Coin;
import com.example.wanandroid.mvp.presenter.personal.UserCoinPresenter;
import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.activity.BaseMVPActivity;

import java.util.List;

import butterknife.BindView;

public class CoinRankActivity extends BaseMVPActivity<UserCoinContract.UserCoinPresenter> implements UserCoinContract.IUserCoinView {
    @BindView(R.id.common_toolbar)
    Toolbar toolbar;
    @BindView(R.id.common_toolbar_title_tv)
    TextView tvTitle;
    CoinRankAdapter mAdapter;

    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_rank)
    TextView tvRank;
    @BindView(R.id.tv_username)
    TextView tvUserName;
    @BindView(R.id.tv_count)
    TextView tvCount;


    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return UserCoinPresenter.newInstance();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        Coin coin = (Coin) bundle.get("coin");
        tvRank.setText(coin.getRank() + "");
        tvUserName.setText(coin.getUsername() + "");
        tvCount.setText(coin.getCoinCount() + "");

        initToolBar(toolbar);
//
        tvTitle.setText("积分排行");
        mAdapter = new CoinRankAdapter(null);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        mPresenter.loadLatestList();


//        toolbar.inflateMenu(R.menu.);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_coin_list;
    }

    @Override
    public void updateContentList(List list) {
        if (mAdapter.getData().size() == 0) {
            initRecyclerView(list);

        } else {
            mAdapter.addData(list);
        }
    }

    private void initRecyclerView(List<Coin> list) {
        mAdapter = new CoinRankAdapter(R.layout.item_coin_rank, list);

        mRecyclerView.setAdapter(mAdapter);

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
