package com.example.myapplication.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.mvp.model.bean.Navi;
import com.example.myapplication.util.BackgroundColor;
import com.example.mylibrary.util.DisplayUtils;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

/**
 * Created by Administrator on 2018/6/25 0025.
 */

public class NavigationAdapter extends BaseCompatAdapter<Navi, BaseViewHolder> {
    public NavigationAdapter(int layoutResId, @Nullable List<Navi> data) {
        super(layoutResId, data);
    }

    public NavigationAdapter(@Nullable List<Navi> data) {
        super(data);
    }

    public NavigationAdapter(int layoutResId) {
        super(layoutResId);
    }


    public interface mTabFlowLayoutListener {
        public void tabFlowLayoutListener(View view, int position, FlowLayout parent, List<Navi.ArticlesBean> mArticles);
    }

    public mTabFlowLayoutListener mTabFlowLayoutListener;

    public void setmTabFlowLayoutListener(NavigationAdapter.mTabFlowLayoutListener mTabFlowLayoutListener) {
        this.mTabFlowLayoutListener = mTabFlowLayoutListener;
    }

    @Override
    protected void convert(BaseViewHolder helper, Navi item) {

        if (!TextUtils.isEmpty(item.getName())) {
            helper.setText(R.id.item_navigation_tv, item.getName()).setBackgroundColor(R.id.item_navigation_tv, BackgroundColor.randomTagColor());
        }
        final TagFlowLayout mTagFlowLayout = helper.getView(R.id.item_navigation_flow_layout);
        final List<Navi.ArticlesBean> mArticles = item.getArticles();
        mTagFlowLayout.setAdapter(new TagAdapter<Navi.ArticlesBean>(mArticles) {
            @Override
            public View getView(final FlowLayout parent, int position, Navi.ArticlesBean feedArticleData) {
                TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.flow_layout_tv,
                        mTagFlowLayout, false);
                if (feedArticleData == null) {
                    return null;
                }
                String name = feedArticleData.getTitle();
//                tv.setPadding(CommonUtils.dp2px(10), CommonUtils.dp2px(10),
//                        CommonUtils.dp2px(10), CommonUtils.dp2px(10));
                tv.setPadding(DisplayUtils.dp2px(10), DisplayUtils.dp2px(10), DisplayUtils.dp2px(10), DisplayUtils.dp2px(10));
                tv.setText(name);
//                tv.setTextColor(CommonUtils.randomColor());

                mTagFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
                    @Override
                    public boolean onTagClick(View view, int position, FlowLayout parent1) {
                        if (mTabFlowLayoutListener != null) {
                            mTabFlowLayoutListener.tabFlowLayoutListener(view, position, parent, mArticles);
                        }
                        return false;
                    }
                });
                return tv;
            }
        });

    }




}
