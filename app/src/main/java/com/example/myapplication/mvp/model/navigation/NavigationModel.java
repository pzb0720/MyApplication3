package com.example.myapplication.mvp.model.navigation;


import com.example.myapplication.api.wanAndroid;
import com.example.myapplication.mvp.contract.NavigationContract;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.Navi;
import com.example.mylibrary.helper.RetrofitCreateHelper;
import com.example.mylibrary.helper.RxHelper;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public class NavigationModel implements NavigationContract.INavigationModel {
    public static NavigationModel newInstance() {

        return new NavigationModel();
    }


    @Override
    public Observable<DataResponse<List<Navi>>> getNavigation() {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getNavigation().compose(RxHelper.<DataResponse<List<Navi>>>rxSchedulerHelper());
    }
}
