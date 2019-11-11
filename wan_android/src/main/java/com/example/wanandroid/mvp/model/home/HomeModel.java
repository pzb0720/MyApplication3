package com.example.wanandroid.mvp.model.home;

import com.example.wanandroid.api.wanAndroid;
import com.example.wanandroid.mvp.contract.HomeContract;
import com.example.wanandroid.mvp.model.bean.Article;
import com.example.wanandroid.mvp.model.bean.DataResponse;
import com.example.wanandroid.mvp.model.bean.TopArticle;
import com.example.wanandroid.mvp.model.bean.WanBanner;
import com.example.mylibrary.helper.RetrofitCreateHelper;
import com.example.mylibrary.helper.RxHelper;

import io.reactivex.Observable;

public class HomeModel implements HomeContract.IHomeModel {
    public static HomeModel newInstance() {
        return new HomeModel();
    }

    @Override
    public Observable<DataResponse<Article>> getArticle(int curPage) {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getArticle(curPage).compose(RxHelper.<DataResponse<Article>>rxSchedulerHelper());
    }

    @Override
    public Observable<WanBanner> getBanner() {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getBanner().compose(RxHelper.<WanBanner>rxSchedulerHelper());
    }

    @Override
    public Observable<TopArticle> getTopList() {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getTop().compose(RxHelper.<TopArticle>rxSchedulerHelper());
    }
}
