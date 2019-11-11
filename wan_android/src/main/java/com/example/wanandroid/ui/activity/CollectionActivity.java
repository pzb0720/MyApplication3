package com.example.wanandroid.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wanandroid.R;
import com.example.wanandroid.adapter.CollectAdapter;
import com.example.wanandroid.constant.RxBusCode;
import com.example.wanandroid.mvp.contract.CollectionContract;
import com.example.wanandroid.mvp.model.bean.Collection;
import com.example.wanandroid.mvp.presenter.personal.CollectionPresenter;
import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.activity.BaseMVPActivity;
import com.example.mylibrary.rxbus.RxBus;
import com.example.mylibrary.util.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public class CollectionActivity extends BaseMVPActivity<CollectionContract.CollectionPresenter> implements CollectionContract.ICollectionView {

    @BindView(R.id.common_toolbar)
    Toolbar toolbar;
    @BindView(R.id.common_toolbar_title_tv)
    TextView tvToolBarName;

    @BindView(R.id.rv_collection)
    RecyclerView rvCollection;

    CollectAdapter mAdapter;

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return CollectionPresenter.newInstance();
    }


    @Override
    public void updateContentList(List list) {
        if (mAdapter.getData().size() == 0) {
            initRecyclerView(list);
        } else {
            mAdapter.addData(list);
        }

    }

    private void initRecyclerView(List<Collection.DatasBean> list) {
        mAdapter = new CollectAdapter(list);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.OnItemClick(position, (Collection.DatasBean) adapter.getItem(position));
            }
        });
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.iv_like) {
                    mPresenter.addCollection(position, (Collection.DatasBean) adapter.getItem(position));
                }
            }
        });
        rvCollection.setAdapter(mAdapter);
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

    @Override
    public void initData() {
        super.initData();
        RxBus.get().register(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        StatusBarUtils.setColor(this, getResources().getColor(R.color.colorPrimary));
        initToolBar(toolbar);

        List<Collection.DatasBean> datasBeanList = new ArrayList<>();
        mAdapter = new CollectAdapter(datasBeanList);

        rvCollection.setLayoutManager(new LinearLayoutManager(this));
        rvCollection.setAdapter(mAdapter);

        tvToolBarName.setText("我的收藏");
        mPresenter.loadLatestList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unRegister(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection;
    }


    @Override
    public void showAddCollectionSuccess(int position, Collection.DatasBean item) {
        item.setOriginId(item.getId());
        mAdapter.notifyDataSetChanged();
        showToast("收藏成功");

    }

    @Override
    public void showRemoveCollectionSuccess(int position, Collection.DatasBean item, int originId) {

        mAdapter.remove(position);
        mAdapter.notifyDataSetChanged();
        showToast("取消收藏成功");
        RxBus.get().send(RxBusCode.RX_BUS_CODE_REMOVE_COLLECTION, String.valueOf(originId));
    }


}

