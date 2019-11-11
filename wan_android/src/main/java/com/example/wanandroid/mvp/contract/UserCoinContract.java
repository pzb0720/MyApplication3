package com.example.wanandroid.mvp.contract;

import com.example.wanandroid.mvp.contract.base.BaseActivityContract;
import com.example.wanandroid.mvp.model.bean.Coin;
import com.example.wanandroid.mvp.model.bean.CoinRank;
import com.example.wanandroid.mvp.model.bean.DataResponse;

import io.reactivex.Observable;

public interface UserCoinContract extends BaseActivityContract {
    abstract class UserCoinPresenter extends BaseActivityContract.BaseActivityPresenter<IUserCoinModel, IUserCoinView, Coin> {

        public abstract void openUserCoinList();
    }

    interface IUserCoinModel extends BaseActivityContract.IBaseActivityModel {

        Observable<DataResponse<CoinRank>> getCoinRank(int curPage);
    }

    interface IUserCoinView extends BaseActivityContract.IBaseActivityView {

    }
}

