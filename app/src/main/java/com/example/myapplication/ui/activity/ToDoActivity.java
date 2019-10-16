package com.example.myapplication.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.myapplication.R;
import com.example.myapplication.adapter.ToDoAdapter;
import com.example.myapplication.mvp.contract.ToDoContract;
import com.example.myapplication.mvp.model.bean.ToDo;
import com.example.myapplication.mvp.presenter.personal.ToDoPresenter;
import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.activity.BaseMVPActivity;
import com.example.mylibrary.rxbus.RxBus;
import com.example.mylibrary.util.StatusBarUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public class ToDoActivity extends BaseMVPActivity<ToDoContract.ToDoPresenter> implements ToDoContract.ITodoView, View.OnClickListener {
    private static final String TAG = "哇哈哈";

    @BindView(R.id.rv_todo)
    RecyclerView mRvToDo;
    @BindView(R.id.common_toolbar_title_tv)
    TextView tvToolBarTitle;
    @BindView(R.id.common_toolbar)
    Toolbar toolbar;
    @BindView(R.id.todo_fab_add)
    FloatingActionButton fabAdd;
    private ToDoAdapter mAdapter;


    @Override
    public void initData() {
        super.initData();
        RxBus.get().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unRegister(this);
    }


    @Override
    protected void initView(Bundle savedInstanceState) {

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressedSupport();
            }
        });
        tvToolBarTitle.setText("TODO");
        StatusBarUtils.setColor(this, getColorPrimary());

        fabAdd.setOnClickListener(this);

        mAdapter = new ToDoAdapter(null);
        mRvToDo.setAdapter(mAdapter);
        mRvToDo.setLayoutManager(new LinearLayoutManager(this));

        mPresenter.getToDoData(1);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_todo;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.todo_fab_add:
                mPresenter.addTodo();
                break;
        }
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return ToDoPresenter.newInstance();
    }

    @Override
    public void updateContentList(List list) {
        initRecyclerView(list);
    }

    private void initRecyclerView(List<ToDo.DataBean.DatasBean> list) {
        Log.i("哇哈哈", "list.size" + list.size());
        mAdapter = new ToDoAdapter(R.layout.item_todo, list);
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.OnItemClick(position, mAdapter.getItem(position));
            }
        });
        mRvToDo.setAdapter(mAdapter);
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
    public void removeItem(int position) {

    }


}
