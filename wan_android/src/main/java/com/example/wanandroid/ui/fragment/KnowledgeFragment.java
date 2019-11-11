package com.example.wanandroid.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wanandroid.R;
import com.example.wanandroid.adapter.KnowledgeAdapter;
import com.example.wanandroid.mvp.contract.KnowledgeContract;
import com.example.wanandroid.mvp.model.bean.Tree;
import com.example.wanandroid.mvp.presenter.knowledge.KnowledgePresenter;
import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.fragment.BaseMVPFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/11/26 0026.
 */

public class KnowledgeFragment extends BaseMVPFragment<KnowledgeContract.KnowledgePresenter> implements KnowledgeContract.IKnowledgeView {
//public class KnowledgeFragment extends BaseFragment {

    @BindView(R.id.recycler)
    RecyclerView rvKnowledge;

    KnowledgeAdapter mAdapter;

    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smartRefreshLayout;

    public static KnowledgeFragment newInstance() {
        Bundle args = new Bundle();
        KnowledgeFragment fragment = new KnowledgeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_knowledge;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        rvKnowledge.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new KnowledgeAdapter(null);
        rvKnowledge.setAdapter(mAdapter);

        smartRefreshLayout.setHeaderHeight(100);//Header标准高度（显示下拉高度>=标准高度 触发刷新）


        smartRefreshLayout.setEnableLoadMore(false);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresenter.loadLatestList();
                refreshLayout.finishRefresh(1000);
            }
        });

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.loadLatestList();
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return KnowledgePresenter.newInstance();
    }


    @Override
    public void updateContentList(List<Tree> list) {
        if (mAdapter.getData().size() == 0) {
            initRecyclerView(list);
        } else {
            mAdapter.replaceData(list);
        }
    }

    private void initRecyclerView(List<Tree> list) {
        mAdapter = new KnowledgeAdapter(R.layout.item_knowledge, list);
//        mAdapter.setOnLoadMoreListener(this, rvKnowledge);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.OnItemClick(position, (Tree) adapter.getItem(position));
            }
        });
        rvKnowledge.setAdapter(mAdapter);


    }

    @Override
    public void itemNotifyChanged(int id) {
        mAdapter.notifyItemChanged(id);
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