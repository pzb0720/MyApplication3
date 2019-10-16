package com.example.myapplication.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.mvp.model.bean.ArticleDataBean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/22 0022.
 */

public class HomeAdapter extends BaseCompatAdapter<ArticleDataBean, BaseViewHolder> {
    public HomeAdapter(int layoutResId, @Nullable List<ArticleDataBean> data) {
        super(layoutResId, data);
    }

    public interface ImageViewLikeClickListener{
         void onImageViewClick(ArticleDataBean item);
    }



    ImageViewLikeClickListener mImageViewLikeClickListener;

    public ImageViewLikeClickListener getmImageViewLikeClickListener() {
        return mImageViewLikeClickListener;
    }

    public void setmImageViewLikeClickListener(ImageViewLikeClickListener mImageViewLikeClickListener) {
        this.mImageViewLikeClickListener = mImageViewLikeClickListener;
    }

    public HomeAdapter(@Nullable List<ArticleDataBean> data) {
        super(data);
    }

    public HomeAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, final ArticleDataBean item) {

        helper.setText(R.id.tv_article_title, item.getTitle());
        helper.setText(R.id.tv_article_author, item.getAuthor());
        helper.setText(R.id.tv_article_classify, item.getChapterName());
        helper.setText(R.id.tv_article_time, item.getNiceDate());
        ImageView ivLike = helper.getView(R.id.iv_like);
        if(item.isCollect()){
            ivLike.setImageResource(R.drawable.ic_action_like);
        }else{
            ivLike.setImageResource(R.drawable.icon_like_article_not_selected);
        }
        helper.addOnClickListener(R.id.iv_like);
//        helper.getView(R.id.iv_like).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i("哇哈哈","iv.onclick");
//                if(mImageViewLikeClickListener!=null){
//                    mImageViewLikeClickListener.onImageViewClick(item);
//                }
//            }
//        });


    }
}
