package com.example.wanandroid.mvp.model.personal;

import com.example.wanandroid.api.wanAndroid;
import com.example.wanandroid.mvp.contract.UserCoinContract;
import com.example.wanandroid.mvp.model.bean.CoinRank;
import com.example.wanandroid.mvp.model.bean.DataResponse;
import com.example.mylibrary.helper.RetrofitCreateHelper;
import com.example.mylibrary.helper.RxHelper;

import io.reactivex.Observable;


public class UserCoinModel implements UserCoinContract.IUserCoinModel {
    public static UserCoinModel newInstance() {
        return new UserCoinModel();
    }

    @Override
    public Observable<DataResponse<CoinRank>> getCoinRank(int curPage) {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getRank(curPage).compose(RxHelper.<DataResponse<CoinRank>>rxSchedulerHelper());
    }
}
