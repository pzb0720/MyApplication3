package com.example.myapplication.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.KnowledgeDetailPagerAdapter;
import com.example.myapplication.constant.BundleKeyConstant;
import com.example.myapplication.mvp.model.bean.Tree;
import com.example.mylibrary.base.ui.activity.BaseActivity;
import com.example.mylibrary.util.StatusBarUtils;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public class KnowledgeDetailActivity extends BaseActivity {
    List<Tree.ChildrenBean> mListChildrenBean;
    String mTitle;
    @BindView(R.id.common_toolbar)
    Toolbar toolbar;
    @BindView(R.id.common_toolbar_title_tv)
    TextView tvCommonTitle;
    @BindView(R.id.knowledge_detail_tab_layout)
    SlidingTabLayout tabSlidingTabLayout;
    @BindView(R.id.knowledge_detail_viewpager)
    ViewPager mVP;

    @Override
    public void initData() {
        super.initData();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mListChildrenBean = (List<Tree.ChildrenBean>) bundle.getSerializable(BundleKeyConstant.ARG_KEY_LIST);
            mTitle = bundle.getString(BundleKeyConstant.ARG_KEY_TITLE);
        }

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        StatusBarUtils.setColor(this, getColorPrimary());
        tvCommonTitle.setText(mTitle);
        toolbar.setNavigationIcon(com.example.mylibrary.R.mipmap.ic_arrow_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KnowledgeDetailActivity.super.onBackPressedSupport();
            }
        });
        KnowledgeDetailPagerAdapter mAdapter = new KnowledgeDetailPagerAdapter(getSupportFragmentManager(), mListChildrenBean);
        mVP.setAdapter(mAdapter);
        tabSlidingTabLayout.setViewPager(mVP);
        //  mVP.setCurrentItem(0);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_knowledege_detail;
    }
}
