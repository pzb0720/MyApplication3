package com.example.wanandroid.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wanandroid.R;
import com.example.wanandroid.adapter.HomeAdapter;
import com.example.wanandroid.mvp.contract.SearchResultContract;
import com.example.wanandroid.mvp.model.bean.ArticleDataBean;
import com.example.wanandroid.mvp.presenter.home.SearchResultPresenter;
import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.activity.BaseMVPActivity;
import com.example.mylibrary.util.StatusBarUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/12/12 0012.
 */

public class SearchResultActivity extends BaseMVPActivity<SearchResultContract.SearchResultPresenter> implements SearchResultContract.ISearchResultView, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rv_search_result)
    RecyclerView rvSearchResult;
    HomeAdapter mAdapter;
    String title = null;


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
    protected void initView(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            title = bundle.getString("name");
        }
        initToolBar(toolbar, title);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        StatusBarUtils.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary));


        mAdapter = new HomeAdapter(R.layout.item_home, null);
        rvSearchResult.setLayoutManager(new LinearLayoutManager(this));
        rvSearchResult.setAdapter(mAdapter);

        errorView = getLayoutInflater().inflate(com.example.mylibrary.R.layout.view_network_error, null);
        emptyView = getLayoutInflater().inflate(com.example.mylibrary.R.layout.view_empty, null);
        loadingView = getLayoutInflater().inflate(com.example.mylibrary.R.layout.view_loading, null);

        mPresenter.loadLatestList(title);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_result;
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return SearchResultPresenter.newInstance();
    }

    @Override
    public void updateContentList(List list) {
        if (mAdapter.getData().size() == 0) {
            initRecyclerView(list);
        } else {
            mAdapter.addData(list);
        }
    }

    private void initRecyclerView(List<ArticleDataBean> list) {
        mAdapter.setNewData(list);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.OnItemClick(position, (ArticleDataBean) adapter.getItem(position));
//                showBottomSheet();
            }
        });

        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.iv_like) {
                    mPresenter.addCollection(position, (ArticleDataBean) adapter.getItem(position));
                }
            }
        });
        mAdapter.setOnLoadMoreListener(this, rvSearchResult);

    }

    @Override
    public void itemNotifyChanged(int id) {
        mAdapter.notifyItemChanged(id);
    }

    @Override
    public void showNetworkError() {
        mAdapter.setEmptyView(errorView);
    }

    @Override
    public void showLoadMoreError() {
        mAdapter.loadMoreFail();
    }

    @Override
    public void showNoMoreData() {
        mAdapter.loadMoreEnd(false);
    }

    @Override
    public void onLoadMoreRequested() {
        rvSearchResult.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.loadMoreList(title);
            }
        }, 1000);
    }

    @Override
    public void showAddCollectionSuccess(int position, ArticleDataBean item) {
        mAdapter.getData().get(position).setCollect(item.isCollect());
        mAdapter.notifyDataSetChanged();
        showToast("收藏成功");
    }

    @Override
    public void showRemoveCollectionSuccess(int position, ArticleDataBean item) {
        mAdapter.getData().get(position).setCollect(item.isCollect());
        mAdapter.notifyDataSetChanged();
        showToast("取消收藏成功");
    }
}
