package com.example.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.myapplication.mvp.model.bean.Tree;
import com.example.myapplication.ui.fragment.ArticleListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/28 0028.
 */

public class KnowledgeDetailPagerAdapter extends FragmentStatePagerAdapter {
    List<Tree.ChildrenBean> mListChildrenBean;
    List<ArticleListFragment> mDataFragment;

    public KnowledgeDetailPagerAdapter(FragmentManager fm, List<Tree.ChildrenBean> listChildrenBean) {
        super(fm);
        mDataFragment = new ArrayList<>();
        this.mListChildrenBean = listChildrenBean;
        for (Tree.ChildrenBean childrenBean : mListChildrenBean) {

            ArticleListFragment fragment = ArticleListFragment.getInstance(childrenBean.getId(), childrenBean.getName());
            mDataFragment.add(fragment);

        }
    }

    @Override
    public Fragment getItem(int position) {
        return mDataFragment.get(position);
    }

    @Override
    public int getCount() {
        return mDataFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return mListChildrenBean.get(position).getName();
    }
}
