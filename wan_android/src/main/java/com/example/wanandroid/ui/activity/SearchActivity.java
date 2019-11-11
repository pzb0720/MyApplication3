package com.example.wanandroid.ui.activity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wanandroid.R;
import com.example.wanandroid.adapter.SearchAdapter;
import com.example.wanandroid.mvp.contract.SearchContract;
import com.example.wanandroid.mvp.model.bean.Friend;
import com.example.wanandroid.mvp.model.bean.HistorySearch;
import com.example.wanandroid.mvp.presenter.home.SearchPresenter;
import com.example.wanandroid.util.BackgroundColor;
import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.activity.BaseMVPActivity;
import com.example.mylibrary.util.StatusBarUtils;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/12/11 0011.
 */

public class SearchActivity extends BaseMVPActivity<SearchContract.SearchPresenter> implements SearchContract.ISearchView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    //    @BindView(R.id.et_toolbar)
//    EditText edToolbar;
    @BindView(R.id.search_flowlayout)
    TagFlowLayout tagFlowLayout;

    @BindView(R.id.rv_history_search)
    RecyclerView rvSearch;

    SearchAdapter hotAdapter;

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

        hotAdapter = new SearchAdapter(null);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
        rvSearch.setLayoutManager(flexboxLayoutManager);

        mPresenter.loadLatestList();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = (SearchView) menu.findItem(R.id.item_search).getActionView();
        searchView.onActionViewExpanded();
        searchView.setQueryHint("输入关键字搜索");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (TextUtils.isEmpty(query)) {
                    return false;
                }
                List<String> data = hotAdapter.getData();
                if (hotAdapter.getData().contains(query)) {
                    int i = data.indexOf(query);
                    data.remove(i);
                    data.add(0, query);
                    hotAdapter.setNewData(data);
                } else {
                    data.add(0, query);
                    hotAdapter.setNewData(data);
                }

                hotAdapter.notifyDataSetChanged();

                mPresenter.searchKey(data, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setSubmitButtonEnabled(true);

        try {
            Field field = searchView.getClass().getDeclaredField("mGoButton");

            field.setAccessible(true);

            ImageView iv = (ImageView) field.get(searchView);

            iv.setImageDrawable(this.getResources().getDrawable(
                    R.drawable.ic_search));
        } catch (Exception e) {
            e.printStackTrace();
        }


        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
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
        setSearchFlowLayoutData(list);
    }

    private void setSearchFlowLayoutData(List<Friend> list) {

        final TagAdapter tagAdapter = new TagAdapter(list) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flow_layout, tagFlowLayout, false);
                TextView tv = view.findViewById(R.id.tv_flow_tag);
                Friend friend = (Friend) o;
                tv.setText(friend.getName());
                tv.setTextColor(BackgroundColor.randomTagColor());
                return view;
            }
        };

        tagFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Friend friend = (Friend) tagFlowLayout.getAdapter().getItem(position);
                mPresenter.OnItemClick(position, friend);
                return true;
            }
        });
        tagFlowLayout.setAdapter(tagAdapter);
    }

    private void initRecyclerView(List<HistorySearch> historySearchList) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < historySearchList.size(); i++) {
            list.add(historySearchList.get(i).getTitle());
        }
        hotAdapter = new SearchAdapter(R.layout.item_hot, list);
        hotAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                mPresenter.OnItemClick(position, (Friend) adapter.getItem(position));
                mPresenter.searchKey(hotAdapter.getData(), (String) adapter.getData().get(position));
            }
        });
        rvSearch.setAdapter(hotAdapter);

//        HistoryAdapter historyAdapter = new HistoryAdapter(R.layout.item_history, list);
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
    public void updateHistoryList(List<HistorySearch> list) {
        initRecyclerView(list);
    }
}
