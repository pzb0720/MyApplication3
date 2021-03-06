package com.example.wanandroid.mvp.model.home;


import com.example.wanandroid.api.wanAndroid;
import com.example.wanandroid.mvp.contract.SearchContract;
import com.example.wanandroid.mvp.model.bean.DataResponse;
import com.example.wanandroid.mvp.model.bean.Friend;
import com.example.mylibrary.helper.RetrofitCreateHelper;
import com.example.mylibrary.helper.RxHelper;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/12/12 0012.
 */

public class SearchModel implements SearchContract.ISearchModel {
    public static SearchModel newInstance() {
        return new SearchModel();
    }


    @Override
    public Observable<DataResponse<List<Friend>>> getHotKey() {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getHotKey().compose(RxHelper.<DataResponse<List<Friend>>>rxSchedulerHelper());
    }


}
