package com.example.wanandroid.mvp.contract;



import com.example.wanandroid.mvp.contract.base.BaseActivityContract;
import com.example.wanandroid.mvp.model.bean.DataResponse;
import com.example.wanandroid.mvp.model.bean.Friend;
import com.example.wanandroid.mvp.model.bean.HistorySearch;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/12/12 0012.
 */

public interface SearchContract {
    abstract class SearchPresenter extends BaseActivityContract.BaseActivityPresenter<ISearchModel, ISearchView, Friend> {
        public abstract void onMenuItemClick(String trim);

        public abstract void searchKey(List<String> data, String query);
    }

    interface ISearchModel extends BaseActivityContract.IBaseActivityModel {
        Observable<DataResponse<List<Friend>>> getHotKey();

    }

    interface ISearchView extends BaseActivityContract.IBaseActivityView {
        void updateHistoryList(List<HistorySearch> list);
    }


}
