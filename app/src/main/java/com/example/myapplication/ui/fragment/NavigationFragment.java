package com.example.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.myapplication.R;
import com.example.myapplication.adapter.GuideAdapter;
import com.example.myapplication.adapter.NavigationAdapter;
import com.example.myapplication.mvp.contract.NavigationContract;
import com.example.myapplication.mvp.model.bean.Navi;
import com.example.myapplication.mvp.presenter.navigation.NavigationPresenter;
import com.example.myapplication.util.RecyclerViewUtils;
import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.fragment.BaseMVPFragment;
import com.zhy.view.flowlayout.FlowLayout;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/11/26 0026.
 */

public class NavigationFragment extends BaseMVPFragment<NavigationContract.NavigationPresenter> implements NavigationContract.INavigationView {
    //public class NavigationFragment extends BaseFragment {
//    @BindView(R.id.normal_view)
//    LinearLayout llNormalView;
    //    @BindView(R.id.navigation_tab_layout)
//    VerticalTabLayout navigationTabLayout;
//    @BindView(R.id.navigation_divider)
//    View navigation_divider;
    private static final String TAG = "哇哈哈 NavigationFragment";
    @BindView(R.id.rv_navigation)
    RecyclerView rvNavigation;

    @BindView(R.id.rv_guide)
    RecyclerView rvGuide;

    NavigationAdapter mAdapter;

    GuideAdapter mGuideAdapter;

    @BindView(R.id.dl_navigation)
    DrawerLayout dlNavigation;

    private LinearLayoutManager mNaviManager;
    private LinearLayoutManager mGuideManager;
    private boolean needScroll;
    private int index;
    private boolean isClickTab;


    public static NavigationFragment newInstance() {

        Bundle args = new Bundle();

        NavigationFragment fragment = new NavigationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_navigation;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {

        mAdapter = new NavigationAdapter(null);
        mNaviManager = new LinearLayoutManager(getContext());
        rvNavigation.setLayoutManager(mNaviManager);
        rvNavigation.setAdapter(mAdapter);
        rvNavigation.setHasFixedSize(true);

        mGuideManager = new LinearLayoutManager(getContext());
        mGuideAdapter = new GuideAdapter(null);
        rvGuide.setLayoutManager(mGuideManager);
        rvGuide.setHasFixedSize(true);
//
//        navigationTabLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.comment_text));
//        navigationTabLayout.setIndicatorColor(ContextCompat.getColor(getContext(),R.color.white));
//        navigationTabLayout.


        dlNavigation.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
            }

            @Override
            public void onDrawerOpened(@NonNull View view) {
                int topNaviPosition = mNaviManager.findFirstCompletelyVisibleItemPosition();
                rvGuide.scrollToPosition(topNaviPosition);
                mGuideAdapter.setSelectPosition(topNaviPosition);
            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
            }

            @Override
            public void onDrawerStateChanged(int i) {
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
        return NavigationPresenter.newInstance();
    }


    @Override
    public void updateContentList(final List<Navi> list) {
//
//        navigationTabLayout.setTabAdapter(new TabAdapter() {
//            @Override
//            public int getCount() {
//                return list == null ? 0 : list.size();
//            }
//
//            @Override
//            public ITabView.TabBadge getBadge(int i) {
//                return null;
//            }
//
//            @Override
//            public ITabView.TabIcon getIcon(int i) {
//                return null;
//            }
//
//            @Override
//            public ITabView.TabTitle getTitle(int i) {
//                return new TabView.TabTitle.Builder()
//                        .setContent(list.get(i).getName())
//                        .setTextColor(ContextCompat.getColor(_mActivity, R.color.shallow_green),
//                                ContextCompat.getColor(_mActivity, R.color.shallow_grey))
//                        .build();
//            }
//
//            @Override
//            public int getBackground(int i) {
//                return -1;
//            }
//        });
//
//        if (list.size() > 0) {
//            setChildViewVisibility(View.VISIBLE);
//        } else {
//            setChildViewVisibility(View.GONE);
//        }


        initRecyclerView(list);
//        leftRightLinkage();


        rvNavigation.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int topPosition = mNaviManager.findFirstVisibleItemPosition();
                Log.i(TAG, "onScrolled: " + topPosition + mAdapter.getItem(topPosition).getName());
                if (topPosition != -1) {
                    RecyclerViewUtils.moveToMiddle(rvGuide, topPosition);
//                    mGuideAdapter.setSelectPosion(topPosition);
                }
            }
        });

    }


    //
//    private void leftRightLinkage() {
//        rvNavigation.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if (needScroll && (newState == RecyclerView.SCROLL_STATE_IDLE)) {
//                    scrollRecyclerView();
//                }
//                rightLinkageLeft(newState);
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                if (needScroll) {
//                    scrollRecyclerView();
//                }
//            }
//        });
//
//        navigationTabLayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabView tabView, int i) {
//                isClickTab = true;
//                selectTag(i);
//            }
//
//            @Override
//            public void onTabReselected(TabView tabView, int i) {
//            }
//        });
//    }
//
//    private void scrollRecyclerView() {
//        needScroll = false;
//        int indexDistance = index - mManager.findFirstVisibleItemPosition();
//        if (indexDistance >= 0 && indexDistance < rvNavigation.getChildCount()) {
//            int top = rvNavigation.getChildAt(indexDistance).getTop();
//            rvNavigation.smoothScrollBy(0, top);
//        }
//    }
//
//
//    /**
//     * Right recyclerView linkage left tabLayout
//     * SCROLL_STATE_IDLE just call once
//     *
//     * @param newState RecyclerView new scroll state
//     */
//    private void rightLinkageLeft(int newState) {
//        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//            if (isClickTab) {
//                isClickTab = false;
//                return;
//            }
//            int firstPosition = mManager.findFirstVisibleItemPosition();
//            if (index != firstPosition) {
//                index = firstPosition;
//                setChecked(index);
//            }
//        }
//    }
//
//    /**
//     * Smooth right to select the position of the left tab
//     *
//     * @param position checked position
//     */
//    private void setChecked(int position) {
//        if (isClickTab) {
//            isClickTab = false;
//        } else {
//            if (navigationTabLayout == null) {
//                return;
//            }
//            navigationTabLayout.setTabSelected(index);
//            navigationTablayoutScrollToPosition(index);
//        }
//        index = position;
//    }
//
//    private void navigationTablayoutScrollToPosition(int index) {
//        TabView tabView = navigationTabLayout.getTabAt(index);
//        int y = navigationTabLayout.getScrollY();
//        int tabTop = tabView.getTop() + tabView.getHeight() / 2 - y;
//        int target = navigationTabLayout.getHeight() / 2;
//        if (tabTop > target) {
//            navigationTabLayout.smoothScrollBy(0, tabTop - target);
//        } else if (tabTop < target) {
//            navigationTabLayout.smoothScrollBy(0, tabTop - target);
//        }
//    }
//
//
//    private void selectTag(int i) {
//        index = i;
//        rvNavigation.stopScroll();
//        smoothScrollToPosition(i);
//    }
//
//
    private void smoothScrollToPosition(int currentPosition) {
        int firstPosition = mNaviManager.findFirstVisibleItemPosition();
        int lastPosition = mNaviManager.findLastVisibleItemPosition();
        if (currentPosition <= firstPosition) {
            rvNavigation.smoothScrollToPosition(currentPosition);
        } else if (currentPosition <= lastPosition) {
            int top = rvNavigation.getChildAt(currentPosition - firstPosition).getTop();
            rvNavigation.smoothScrollBy(0, top);
        } else {
            rvNavigation.smoothScrollToPosition(currentPosition);
            needScroll = true;
        }
    }
//
//
    private void initRecyclerView(List<Navi> list) {
        if (mAdapter.getData().size() == 0) {
            mAdapter = new NavigationAdapter(R.layout.item_navigation, list);
            mAdapter.setmTabFlowLayoutListener(new NavigationAdapter.mTabFlowLayoutListener() {
                @Override
                public void tabFlowLayoutListener(View view, int position, FlowLayout parent, List<Navi.ArticlesBean> mArticles) {
                    mPresenter.OnTabFlowLayoutItemClick(position, mArticles);
                }
            });
            rvNavigation.setAdapter(mAdapter);
        } else {
            mAdapter.replaceData(list);
        }


        if (mGuideAdapter.getData().size() == 0) {
            mGuideAdapter = new GuideAdapter(R.layout.item_guide, list);
            mGuideAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    rvNavigation.scrollToPosition(position);
                    mGuideAdapter.setSelectPosition(position);

//                    if (dlNavigation.isDrawerOpen(GravityCompat.START)) {
//                        dlNavigation.closeDrawer(GravityCompat.START);
//                    }
                }
            });
            rvGuide.setAdapter(mGuideAdapter);
        } else {
            mGuideAdapter.replaceData(list);
        }


    }


    //    private void setChildViewVisibility(int visible) {
//        navigation_divider.setVisibility(visible);
//        navigationTabLayout.setVisibility(visible);
//        llNormalView.setVisibility(visible);
//    }
//
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

