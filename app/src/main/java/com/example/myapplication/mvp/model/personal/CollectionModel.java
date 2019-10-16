package com.example.myapplication.mvp.model.personal;


import com.example.myapplication.api.wanAndroid;
import com.example.myapplication.mvp.contract.CollectionContract;
import com.example.myapplication.mvp.model.bean.Collection;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.mylibrary.helper.RetrofitCreateHelper;
import com.example.mylibrary.helper.RxHelper;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public class CollectionModel implements CollectionContract.ICollectionModel {
    public static CollectionModel newInstance() {

        return new CollectionModel();
    }


    @Override
    public Observable<DataResponse<Collection>> getCollectionArticle(int page) {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getCollectArticles(page).compose(RxHelper.<DataResponse<Collection>>rxSchedulerHelper());
    }
}
