package com.example.myapplication.adapter;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.mvp.model.bean.ToDo;

import java.util.List;

public class ToDoAdapter extends BaseCompatAdapter<ToDo.DataBean.DatasBean, BaseViewHolder> {
    public ToDoAdapter(int layoutResId, @Nullable List<ToDo.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    public ToDoAdapter(@Nullable List<ToDo.DataBean.DatasBean> data) {
        super(data);
    }

    public ToDoAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, ToDo.DataBean.DatasBean item) {
        helper.setText(R.id.tv_todo_title, item.getTitle());
        helper.setText(R.id.tv_todo_date, item.getDateStr());
        helper.setText(R.id.tv_todo_content, item.getContent());
        helper.addOnClickListener(R.id.iv_todo_setting);

        Drawable drawable = ContextCompat.getDrawable(mContext, R.drawable.ic_tag);
        if (item.getStatus() == 1) {
            drawable = ContextCompat.getDrawable(mContext, R.drawable.ic_yiwancheng);
        } else if (item.getDate() + 24 * 60 * 60 * 1000 < System.currentTimeMillis()) {
            Log.i("哇哈哈", "已经超时");
            drawable = ContextCompat.getDrawable(mContext, R.drawable.ic_yichaoshi);
        } else {
            drawable = ContextCompat.getDrawable(mContext, R.drawable.ic_tag);
        }

        Glide.with(mContext).load(drawable).into((ImageView) helper.getView(R.id.iv_todo_tag));
    }
}
