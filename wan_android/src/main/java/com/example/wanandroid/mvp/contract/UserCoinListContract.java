package com.example.wanandroid.mvp.contract;

import com.example.wanandroid.mvp.contract.base.BaseActivityContract;
import com.example.wanandroid.mvp.model.bean.CoinList;
import com.example.wanandroid.mvp.model.bean.DataResponse;

import io.reactivex.Observable;

public interface UserCoinListContract extends BaseActivityContract {
    abstract class UserCoinListPresenter extends BaseActivityContract.BaseActivityPresenter<IUserCoinListModel, IUserCoinListView, CoinList.DatasBean> {

        public abstract void openUserCoinList();
    }

    interface IUserCoinListModel extends BaseActivityContract.IBaseActivityModel {

        Observable<DataResponse<CoinList>> getCoinList(int curPage);
    }

    interface IUserCoinListView extends BaseActivityContract.IBaseActivityView {

    }
}
