package com.example.myapplication.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.mvp.model.bean.Collection;

import java.util.List;

/**
 * Created by Administrator on 2018/6/22 0022.
 */

public class CollectAdapter extends BaseMultiItemQuickAdapter<Collection.DatasBean, BaseViewHolder> {
    public static final int ARTICLE = 1;
    public static final int PROJECT = 2;

    public CollectAdapter(@Nullable List<Collection.DatasBean> data) {
        super(data);
        addItemType(ARTICLE, R.layout.item_article);
        addItemType(PROJECT, R.layout.item_project);

    }


    @Override
    protected void convert(BaseViewHolder helper, final Collection.DatasBean item) {

        helper.setText(R.id.tv_article_title, item.getTitle());
        helper.setText(R.id.tv_article_author, item.getAuthor());
        StringBuffer stringBuffer = new StringBuffer();
//        if (!TextUtils.isEmpty(item.getSuperChapterName())) {
//            stringBuffer.append(item.getSuperChapterName());
//            stringBuffer.append("·");
//        }
        stringBuffer.append(item.getChapterName());

        helper.setText(R.id.tv_article_classify, stringBuffer.toString());
//        helper.setText(R.id.tv_article_classify, TextUtils.isEmpty(item.getSuperChapterName()) ? "" : item.getSuperChapterName() + "·" + item.getChapterName());
        helper.setText(R.id.tv_article_time, item.getNiceDate());

        ImageView ivLike = helper.getView(R.id.iv_like);

        ivLike.setImageResource(R.drawable.ic_action_like);

        helper.addOnClickListener(R.id.iv_like);

        if (item.getItemType() == PROJECT) {
            //
            Log.i("哇哈哈", "添加图片");
            RequestOptions options = new RequestOptions();
            options.error(R.drawable.load_error);
            Glide.with(mContext).load(item.getEnvelopePic()).apply(options).into((ImageView) helper.getView(R.id.iv_pic));
            TextView tvProject = helper.getView(R.id.tv_article_project);
            tvProject.setVisibility(View.GONE);
        } else {
            TextView tvQuestion = helper.getView(R.id.tv_article_question);
            tvQuestion.setVisibility(View.GONE);
        }

        helper.setGone(R.id.tv_article_top, false);
        helper.setGone(R.id.tv_article_new, false);

    }


}
