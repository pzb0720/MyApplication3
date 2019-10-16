package com.example.myapplication.mvp.model.personal;


import com.example.myapplication.api.wanAndroid;
import com.example.myapplication.mvp.contract.PersonalContract;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.Rank;
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
    public Observable<Rank> getRank() {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getuserCoin().compose(RxHelper.<Rank>rxSchedulerHelper());
    }
}
