package com.example.myapplication.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.ui.widget.MyColorCircleView;

import java.util.List;

public class PriorityAdapter extends BaseCompatAdapter<String, BaseViewHolder> {
    private String itemSelect = null;

    public PriorityAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    public PriorityAdapter(@Nullable List<String> data) {
        super(data);
    }

    public PriorityAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_item_title, item);
        MyColorCircleView colorCircleView = helper.getView(R.id.item_circle_view);
        if (TextUtils.equals(item, mContext.getResources().getString(R.string.priority_first))) {
            colorCircleView.setCircleColor(mContext.getResources().getColor(R.color.md_red_500));
        } else if (TextUtils.equals(item, mContext.getResources().getString(R.string.priority_second))) {
            colorCircleView.setCircleColor(mContext.getResources().getColor(R.color.md_orange_500));
        } else if (TextUtils.equals(item, mContext.getResources().getString(R.string.priority_third))) {
            colorCircleView.setCircleColor(mContext.getResources().getColor(R.color.md_blue_700));
        } else if (TextUtils.equals(item, mContext.getResources().getString(R.string.priority_fourth))) {
            colorCircleView.setCircleColor(mContext.getResources().getColor(R.color.md_green_500));
        }
        if (TextUtils.equals(item, itemSelect)) {
            colorCircleView.setViewIsSelect(true);
        } else {
            colorCircleView.setViewIsSelect(false);
        }
    }

    public void setItemSelect(String str) {
        this.itemSelect = str;
        notifyDataSetChanged();
    }


    public void setItemSelect(int id) {
        switch (id) {
            case 0:
                itemSelect = mContext.getResources().getString(R.string.priority_first);
                break;
            case 1:
                itemSelect = mContext.getResources().getString(R.string.priority_second);
                break;
            case 2:
                itemSelect = mContext.getResources().getString(R.string.priority_third);
                break;
            case 3:
                itemSelect = mContext.getResources().getString(R.string.priority_fourth);
                break;
        }
        notifyDataSetChanged();
    }
}
