package com.example.myapplication.mvp.model.home;


import com.example.myapplication.api.wanAndroid;
import com.example.myapplication.mvp.contract.SearchResultContract;
import com.example.myapplication.mvp.model.bean.Article;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.mylibrary.helper.RetrofitCreateHelper;
import com.example.mylibrary.helper.RxHelper;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/12/14 0014.
 */

public class SearchResultModel implements SearchResultContract.ISearchResultModel {
    public static SearchResultModel newInstance() {
        return new SearchResultModel();
    }


    @Override
    public Observable<DataResponse<Article>> getSearchArticles(int page, String k) {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getSearchArticles(page, k).compose(RxHelper.<DataResponse<Article>>rxSchedulerHelper());
    }
}
