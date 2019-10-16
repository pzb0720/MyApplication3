package com.example.myapplication.util;

import android.text.TextUtils;

import com.example.myapplication.adapter.ArticleAdapter;
import com.example.myapplication.mvp.model.bean.ArticleDataBean;
import com.example.myapplication.mvp.model.bean.Collection;

import java.util.List;

public class UpdateItemTypeUtil {
    public static List<ArticleDataBean> updateArticleItemType(List<ArticleDataBean> dataBeans) {
        List<ArticleDataBean> datas = dataBeans;
        for (ArticleDataBean dataBean : datas) {
            if (TextUtils.isEmpty(dataBean.getEnvelopePic())) {
                dataBean.setItemType(ArticleAdapter.ARTICLE);
            } else {
                dataBean.setItemType(ArticleAdapter.PROJECT);
            }
        }
        return datas;
    }

    public static List<Collection.DatasBean> updateCollectItemType(List<Collection.DatasBean> dataBeans){
        List<Collection.DatasBean> datas = dataBeans;
        for (Collection.DatasBean dataBean : datas) {
            if (TextUtils.isEmpty(dataBean.getEnvelopePic())) {
                dataBean.setItemType(ArticleAdapter.ARTICLE);
            } else {
                dataBean.setItemType(ArticleAdapter.PROJECT);
            }
        }
        return datas;
    }

}
