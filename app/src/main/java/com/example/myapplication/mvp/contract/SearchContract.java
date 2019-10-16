package com.example.myapplication.mvp.contract;



import com.example.myapplication.mvp.contract.base.BaseActivityContract;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.Friend;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/12/12 0012.
 */

public interface SearchContract {
    abstract class SearchPresenter extends BaseActivityContract.BaseActivityPresenter<ISearchModel, ISearchView, Friend> {
        public abstract void onMenuItemClick(String trim);
    }

    interface ISearchModel extends BaseActivityContract.IBaseActivityModel {
        Observable<DataResponse<List<Friend>>> getHotKey();

    }

    interface ISearchView extends BaseActivityContract.IBaseActivityView {
    }


}
