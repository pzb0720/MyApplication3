package com.example.myapplication.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.mvp.model.bean.Friend;

import java.util.List;

import static com.example.myapplication.util.BackgroundColor.randomTagColor;


/**
 * Created by Administrator on 2018/12/12 0012.
 */

public class HotAdapter extends BaseCompatAdapter<Friend, BaseViewHolder> {
    public HotAdapter(int layoutResId, @Nullable List<Friend> data) {
        super(layoutResId, data);
    }

    public HotAdapter(@Nullable List<Friend> data) {
        super(data);
    }

    public HotAdapter(int layoutResId) {
        super(layoutResId);
    }




    @Override
    protected void convert(BaseViewHolder helper, Friend item) {
        helper.setText(R.id.tv_title, item.getName()).setBackgroundColor(R.id.tv_title, randomTagColor());

    }
}
