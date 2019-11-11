package com.example.wanandroid.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.wanandroid.R;
import com.example.wanandroid.ui.fragment.HomeRootFragment;
import com.example.wanandroid.ui.fragment.KnowledgeFragment;
import com.example.wanandroid.ui.fragment.NavigationFragment;
import com.example.wanandroid.ui.fragment.PersonalFragment;
import com.example.mylibrary.base.ui.activity.BaseActivity;
import com.example.mylibrary.util.ToastUtils;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity  extends BaseActivity {

    @BindView(R.id.main_bottom_navigation_view)
    BottomNavigationView mBottomNavigationView;
//    @BindView(R.id.common_toolbar)
//    Toolbar mToolbar;
//    @BindView(R.id.common_toolbar_title_tv)
//    TextView tvToolbarTitle;

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;

    private SupportFragment[] mFragments = new SupportFragment[4];


    private static final long WAIT_EXIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mFragments[FIRST] = HomeRootFragment.newInstance();
            mFragments[SECOND] = KnowledgeFragment.newInstance();
            mFragments[THIRD] = NavigationFragment.newInstance();
            mFragments[FOURTH] = PersonalFragment.newInstance();
//            mFragments[FOURTH] = TestFragment.newInstance();
            loadMultipleRootFragment(R.id.fragment_root, FIRST
                    , mFragments[FIRST]
                    , mFragments[SECOND]
                    , mFragments[THIRD]
                    , mFragments[FOURTH]
            );
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.getFragments()
            // 自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = findFragment(HomeRootFragment.class);
            mFragments[SECOND] = findFragment(KnowledgeFragment.class);
            mFragments[THIRD] = findFragment(NavigationFragment.class);
            mFragments[FOURTH] = findFragment(PersonalFragment.class);
//            mFragments[FOURTH] = findFragment(TestFragment.class);
        }
//        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_main:
                        showHideFragment(mFragments[FIRST]);
//                        tvToolbarTitle.setText(R.string.navigation_main);
                        break;
                    case R.id.navigation_knowledge_hierarchy:
                        showHideFragment(mFragments[SECOND]);
//                        tvToolbarTitle.setText(R.string.navigation_knowledge_hierarchy);
                        break;
                    case R.id.navigation_navigation:
                        showHideFragment(mFragments[THIRD]);

//                        tvToolbarTitle.setText(R.string.navigation_navigation);
                        break;
                    case R.id.navigation_my:
                        showHideFragment(mFragments[FOURTH]);
//                        tvToolbarTitle.setText(R.string.navigation_me);
                        break;
                }
                return true;
            }
        });


    }


    @Override
    public void onBackPressedSupport() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            pop();
        } else {
            if (System.currentTimeMillis() - TOUCH_TIME < WAIT_EXIT_TIME) {
                checkAndExit();
            } else {
                TOUCH_TIME = System.currentTimeMillis();
                ToastUtils.showToast(R.string.press_again);
            }
        }
    }

    private void checkAndExit() {
        setTransAnim(false);
        finish();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
