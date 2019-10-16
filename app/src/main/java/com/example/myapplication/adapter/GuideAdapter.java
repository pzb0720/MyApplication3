package com.example.myapplication.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.mvp.model.bean.Navi;

import java.util.List;

public class GuideAdapter extends BaseCompatAdapter<Navi, BaseViewHolder> {
    private int topPosition = 0;

    public GuideAdapter(int layoutResId, @Nullable List<Navi> data) {
        super(layoutResId, data);
    }

    public GuideAdapter(@Nullable List<Navi> data) {
        super(data);
    }

    public GuideAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, Navi item) {
        helper.setText(R.id.item_guide_tv, item.getName());
        TextView tvName = helper.getView(R.id.item_guide_tv);
        Log.i("哇哈哈", getData().get(topPosition).getName() + "  name " + item.getName());
        if (TextUtils.equals(getData().get(topPosition).getName(), item.getName())) {

//            view.setVisibility(View.VISIBLE);
            Log.i("哇哈哈", getData().get(topPosition).getName() + "  true " + item.getName());
            tvName.setBackgroundResource(R.color.color_107);
            tvName.setTextColor(mContext.getResources().getColor(R.color.color_002));
        } else {
//            view.setVisibility(View.GONE);
            tvName.setBackgroundResource(R.color.color_109);
            tvName.setTextColor(mContext.getResources().getColor(R.color.color_100));
        }
    }

    public void setSelectPosition(int position) {
        this.topPosition = position;
        notifyDataSetChanged();

    }
}
