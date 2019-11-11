package com.example.wanandroid.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wanandroid.R;
import com.example.wanandroid.adapter.ArticleAdapter;
import com.example.wanandroid.mvp.contract.HomeContract;
import com.example.wanandroid.mvp.model.bean.ArticleDataBean;
import com.example.wanandroid.mvp.model.bean.WanBanner;
import com.example.wanandroid.mvp.presenter.home.HomePresenter;
import com.example.wanandroid.ui.activity.HotActivity;
import com.example.wanandroid.ui.activity.SearchActivity;
import com.example.wanandroid.util.GlideImageLoader;
import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.fragment.BaseMVPFragment;
import com.example.mylibrary.rxbus.RxBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by Administrator on 2018/11/26 0026.
 */

public class HomeRootFragment extends BaseMVPFragment<HomeContract.HomePresenter> implements HomeContract.IHomeView {
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout mSrlHome;
    @BindView(R.id.recycler)
    RecyclerView rvHome;

    Banner mBanner;

    ArticleAdapter mAdapter;

    @BindView(R.id.common_toolbar)
    Toolbar mToolbar;

    private List<String> mBannerImageList;
    private List<String> mBannerTitleList;
    private List<String> mBannerUrlList;


    public static HomeRootFragment newInstance() {
        Bundle args = new Bundle();
        HomeRootFragment fragment = new HomeRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

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
    public void onResume() {
        super.onResume();
        if (mBanner != null) {
            mBanner.startAutoPlay();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mBanner != null) {
            mBanner.stopAutoPlay();
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.loadAllList(true);
        Log.i(TAG, "onLazyInitView: ");
    }


    @Override
    public void initView(View view, Bundle savedInstanceState) {
        List<ArticleDataBean> dataBeans = new ArrayList<>();
        mAdapter = new ArticleAdapter(dataBeans);
        rvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        LinearLayout headerView = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.head_banner, null);
        mBanner = headerView.findViewById(R.id.head_banner);
        headerView.removeView(mBanner);
        rvHome.setAdapter(mAdapter);
        initSmartRefreshLayout();
        mToolbar.inflateMenu(R.menu.main_menu);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_main_hot:
                        Intent intent = new Intent(getActivity(), HotActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.item_main_search:
                        Intent intentSearch = new Intent(getActivity(), SearchActivity.class);
                        startActivity(intentSearch);
                        break;
                }
                return false;
            }
        });

    }


    private void initSmartRefreshLayout() {
//        mSrlHome.setHeaderHeight(100);//Header标准高度（显示下拉高度>=标准高度 触发刷新）
//        mSrlHome.setRefreshFooter(new ClassicsFooter(getContext()));
//        final TextView tv = mSrlHome.getLayout().findViewById(ID_TEXT_TITLE);
//        final AtomicBoolean net = new AtomicBoolean(true);
//        final String REFRESH_FOOT_PULLING = "上拉可以加载";//"下拉可以刷新";
//        final String REFRESH_FOOT_LOADING = "正在加载...";//"正在加载...";
//        final String REFRESH_FOOT_RELEASE = "释放立即刷新";
//        final String REFRESH_FOOT_FINISH = "加载成功";//"刷新完成";
//        final String REFRESH_FOOT_FAILED = "加载失败";//"刷新失败";
//
//        mSrlHome.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
//            @Override
//            public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
//                switch (newState) {
//                    case PullUpToLoad: //下拉过程
//                        tv.setText(REFRESH_FOOT_PULLING);
//                        break;
//                    case ReleaseToLoad: //松开刷新
//                        tv.setText(REFRESH_FOOT_RELEASE);
//                        break;
//                    case Loading:
//                    case LoadReleased:
//                    case Refreshing: //loading中
//                        tv.setText(REFRESH_FOOT_LOADING);
//                        if (NetworkConnectionUtils.isNetworkConnected(getContext())) {
//                            net.set(true);
//                        } else {
//                            net.set(false);
//                        }
//                        break;
//                }
//            }
//
//            @Override
//            public void onFooterFinish(RefreshFooter footer, boolean success) {
//                super.onFooterFinish(footer, success);
//                if (net.get() == false) {
//                    tv.setText("请检查网络设置");
//                } else if (net.get() == true && success) {
//                    tv.setText(REFRESH_FOOT_FINISH);
//                } else if (net.get() == true && !success) {
//                    tv.setText(REFRESH_FOOT_FAILED);
//                }
//            }
//        });


        mSrlHome.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPresenter.loadMoreList();
                refreshLayout.finishLoadMore(1000);
            }
        });

        mSrlHome.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresenter.loadAllList(true);
                refreshLayout.finishRefresh(1000);
            }
        });
    }


    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return HomePresenter.newInstance();
    }


    @Override
    public void updateContentList(List<ArticleDataBean> list) {
        mAdapter.addData(list);
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
    public void updateBanner(WanBanner banner) {
        List<WanBanner.DataBean> banners = banner.getData();
        mBannerImageList = new ArrayList<>();
        mBannerTitleList = new ArrayList<>();
        mBannerUrlList = new ArrayList<>();
        for (WanBanner.DataBean bean : banners) {
            mBannerImageList.add(bean.getImagePath());
            mBannerTitleList.add(bean.getTitle());
            mBannerUrlList.add(bean.getUrl());
        }

        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(mBannerImageList);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(mBannerTitleList);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(banners.size() * 400);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);

        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    @Override
    public void updateLatestList(List<ArticleDataBean> list, boolean isRefresh) {
        mSrlHome.finishRefresh(500);
        if (mAdapter.getData().size() == 0) {
            mAdapter = new ArticleAdapter(list);
            mAdapter.setTag(true);
            mAdapter.addHeaderView(mBanner);
            rvHome.setAdapter(mAdapter);
        } else {
            mAdapter.setNewData(list);
        }

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.OnItemClick(position, (ArticleDataBean) adapter.getItem(position));
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
