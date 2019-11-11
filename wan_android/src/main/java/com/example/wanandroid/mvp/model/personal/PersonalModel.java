package com.example.wanandroid.mvp.model.personal;


import com.example.wanandroid.api.wanAndroid;
import com.example.wanandroid.mvp.contract.PersonalContract;
import com.example.wanandroid.mvp.model.bean.Coin;
import com.example.wanandroid.mvp.model.bean.DataResponse;
import com.example.mylibrary.helper.RetrofitCreateHelper;
import com.example.mylibrary.helper.RxHelper;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public class PersonalModel implements PersonalContract.IPersonalModel {
    public static PersonalModel newInstance() {
        return new PersonalModel();
    }

    @Override
    public Observable<DataResponse<Coin>> getUserCoin() {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getUserCoin().compose(RxHelper.<DataResponse<Coin>>rxSchedulerHelper());
    }
}
