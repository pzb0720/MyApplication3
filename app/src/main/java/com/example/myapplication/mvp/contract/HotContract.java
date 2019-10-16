package com.example.myapplication.mvp.contract;


import com.example.myapplication.mvp.contract.base.BaseActivityContract;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.Friend;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2018/12/12 0012.
 */

public interface HotContract {
    abstract class HotPresenter extends BaseActivityContract.BaseActivityPresenter<IHotModel, IHotActivity, Friend> {

    }

    interface IHotModel extends BaseActivityContract.IBaseActivityModel {
        Observable<DataResponse<List<Friend>>> getFriend();
    }

    interface IHotActivity extends BaseActivityContract.IBaseActivityView<Friend> {
    }

}
