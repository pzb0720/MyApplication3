package com.example.myapplication.mvp.model.knowledge;


import com.example.myapplication.api.wanAndroid;
import com.example.myapplication.mvp.contract.ArticleListContract;
import com.example.myapplication.mvp.model.bean.Article;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.mylibrary.helper.RetrofitCreateHelper;
import com.example.mylibrary.helper.RxHelper;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public class ArticleListModel implements ArticleListContract.IArticleListModel {
    public static ArticleListModel newInstance() {

        return new ArticleListModel();
    }


    @Override
    public Observable<DataResponse<Article>> getTreeArticle(int currentPage, int cid) {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getTreeArticle(currentPage, cid).compose(RxHelper.<DataResponse<Article>>rxSchedulerHelper());
    }
}
