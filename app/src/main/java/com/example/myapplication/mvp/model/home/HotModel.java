package com.example.myapplication.mvp.model.home;


import com.example.myapplication.api.wanAndroid;
import com.example.myapplication.mvp.contract.HotContract;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.Friend;
import com.example.mylibrary.helper.RetrofitCreateHelper;
import com.example.mylibrary.helper.RxHelper;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/12/12 0012.
 */

public class HotModel implements HotContract.IHotModel {
    public static HotModel newInstance() {
        return new HotModel();
    }

    @Override
    public Observable<DataResponse<List<Friend>>> getFriend() {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getFriends().compose(RxHelper.<DataResponse<List<Friend>>>rxSchedulerHelper());
    }
}
