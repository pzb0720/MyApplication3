package com.example.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.myapplication.R;
import com.example.myapplication.adapter.ArticleAdapter;
import com.example.myapplication.constant.BundleKeyConstant;
import com.example.myapplication.mvp.contract.ArticleListContract;
import com.example.myapplication.mvp.model.bean.ArticleDataBean;
import com.example.myapplication.mvp.presenter.knowledge.ArticleListPresenter;
import com.example.myapplication.ui.widget.MyClassicsRefreshLayout;
import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.fragment.BaseRecyclerFragment;
import com.example.mylibrary.util.NetworkConnectionUtils;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import butterknife.BindView;

import static com.scwang.smartrefresh.layout.internal.InternalClassics.ID_TEXT_TITLE;

/**
 * Created by Administrator on 2018/6/28 0028.
 */

public class ArticleListFragment extends BaseRecyclerFragment<ArticleListContract.ArticleListPresenter> implements ArticleListContract.IArticleListView {
    //public class ArticleListFragment extends BaseFragment {
    @BindView(R.id.recycler)
    RecyclerView rvArticle;

    @BindView(R.id.smart_refresh_layout)
    MyClassicsRefreshLayout mSrl;
    String mName;
    int mCid;

    //    HomeAdapter mAdapter;
    ArticleAdapter mAdapter;

//    public int currentPage = 0;
//    public int pageCount;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_article_list;
    }

    @Override
    public void initData() {
        super.initData();

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.getTreeArticleList(mCid);
    }

    @Override
    protected void showLoading() {
        mAdapter.setEmptyView(loadingView);
    }

    @Override
    protected void onErrorViewClick(View v) {

    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        mName = bundle.getString(BundleKeyConstant.ARG_KEY_TITLE);
        mCid = bundle.getInt(BundleKeyConstant.ARG_KEY_INT);
        rvArticle.setLayoutManager(new LinearLayoutManager(getContext()));
//        mAdapter = new HomeAdapter(null);
        List<ArticleDataBean> list = new ArrayList<>();
        mAdapter = new ArticleAdapter(list);
        rvArticle.setAdapter(mAdapter);

        initSmartRefreshLayout();

    }

    private void initSmartRefreshLayout() {
        mSrl.setHeaderHeight(100);//Header标准高度（显示下拉高度>=标准高度 触发刷新）
        mSrl.setRefreshFooter(new ClassicsFooter(getContext()));

        final TextView tv = mSrl.getLayout().findViewById(ID_TEXT_TITLE);
        final AtomicBoolean net = new AtomicBoolean(true);
        final String REFRESH_FOOT_PULLING = "上拉可以加载";//"下拉可以刷新";
        final String REFRESH_FOOT_LOADING = "正在加载...";//"正在加载...";
        final String REFRESH_FOOT_RELEASE = "释放立即刷新";
        final String REFRESH_FOOT_FINISH = "加载成功";//"刷新完成";
        final String REFRESH_FOOT_FAILED = "加载失败";//"刷新失败";

        mSrl.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
            @Override
            public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
                switch (newState) {
                    case PullUpToLoad: //下拉过程
                        tv.setText(REFRESH_FOOT_PULLING);
                        break;
                    case ReleaseToLoad: //松开刷新
                        tv.setText(REFRESH_FOOT_RELEASE);
                        break;
                    case Loading:
                    case LoadReleased:
                    case Refreshing: //loading中
                        tv.setText(REFRESH_FOOT_LOADING);
                        if (NetworkConnectionUtils.isNetworkConnected(getContext())) {
                            net.set(true);
                        } else {
                            net.set(false);
                        }
                        break;
                }
            }

            @Override
            public void onFooterFinish(RefreshFooter footer, boolean success) {
                super.onFooterFinish(footer, success);
                if (net.get() == false) {
                    tv.setText("请检查网络设置");
                } else if (net.get() == true && success) {
                    tv.setText(REFRESH_FOOT_FINISH);
                } else if (net.get() == true && !success) {
                    tv.setText(REFRESH_FOOT_FAILED);
                }
            }
        });


        mSrl.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPresenter.loadMoreList();
                refreshLayout.finishLoadMore(1000);
            }
        });

        mSrl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresenter.getTreeArticleList(mCid);
                refreshLayout.finishRefresh(1000);
            }
        });


    }

    public static ArticleListFragment getInstance(int id, String title) {
        ArticleListFragment fragment = new ArticleListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BundleKeyConstant.ARG_KEY_TITLE, title);
        bundle.putInt(BundleKeyConstant.ARG_KEY_INT, id);
        fragment.setArguments(bundle);
        return fragment;
    }


    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return ArticleListPresenter.newInstance();
    }


    @Override
    public void updateContentList(List list) {
        if (mAdapter.getData().size() == 0) {
            initRecyclerView(list);
        } else {
            mAdapter.addData(list);
        }
    }

    private void initRecyclerView(List list) {

        rvArticle.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new ArticleAdapter(list);
        rvArticle.setAdapter(mAdapter);

//        mAdapter = new HomeAdapter(R.layout.item_home, list);
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

//        mAdapter.setOnLoadMoreListener(this, rvArticle);
        rvArticle.setAdapter(mAdapter);
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

//    @Override
//    public void onLoadMoreRequested() {
//
//
////        if (currentPage < pageCount) {
////            mAdapter.loadMoreComplete();
////            mPresenter.loadMoreList();

////        } else {
////            mAdapter.loadMoreEnd(false);
////        }
//    }

    @Override
    public void updateContent(List<ArticleDataBean> list) {
        if (mAdapter.getData().size() == 0) {
//            currentPage = list.getCurPage();
//            pageCount = list.getPageCount();
            initRecyclerView(list);
        } else {
//            currentPage = list.getCurPage();
            mAdapter.addData(list);
        }
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
