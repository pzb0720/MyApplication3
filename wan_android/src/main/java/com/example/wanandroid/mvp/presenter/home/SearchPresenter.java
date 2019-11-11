package com.example.wanandroid.mvp.presenter.home;

import android.os.Bundle;

import com.example.wanandroid.db.HistoryDbManager;
import com.example.wanandroid.mvp.contract.SearchContract;
import com.example.wanandroid.mvp.model.bean.DataResponse;
import com.example.wanandroid.mvp.model.bean.Friend;
import com.example.wanandroid.mvp.model.bean.HistorySearch;
import com.example.wanandroid.mvp.model.home.SearchModel;
import com.example.wanandroid.ui.activity.SearchResultActivity;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/12/12 0012.
 */

public class SearchPresenter extends SearchContract.SearchPresenter {
    public static SearchPresenter newInstance() {
        return new SearchPresenter();
    }

    @Override
    protected SearchContract.ISearchModel getModel() {
        return SearchModel.newInstance();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void loadMoreList() {

    }

    @Override
    public void loadLatestList() {
        if (mIModel == null) return;

        List<HistorySearch> list = HistoryDbManager.getHistorySearchList();

        List<HistorySearch> descHistorySearchList = HistoryDbManager.getDescHistorySearchList();
        mIView.updateHistoryList(descHistorySearchList);

        mRxManager.register(mIModel.getHotKey().subscribe(new Consumer<DataResponse<List<Friend>>>() {
            @Override
            public void accept(DataResponse<List<Friend>> listDataResponse) throws Exception {
                if (mIView != null) {
                    mIView.updateContentList(listDataResponse.getData());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mIView.showToast(throwable.getMessage());
            }
        }));
    }

    @Override
    public void OnItemClick(int position, Friend item) {
        Bundle bundle = new Bundle();
        item.getId();
        bundle.putString("name", item.getName());
        mIView.startNewActivity(SearchResultActivity.class, bundle);
    }

    @Override
    public void onMenuItemClick(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("name", str);
        mIView.startNewActivity(SearchResultActivity.class, bundle);
    }

    @Override
    public void searchKey(List<String> data, String query) {

        HistoryDbManager.deleteHistory(query);

        HistorySearch search = new HistorySearch();
        search.setTitle(query);
        search.setTime(System.currentTimeMillis());
        HistoryDbManager.saveHistory(search);

        Bundle bundle = new Bundle();
        bundle.putString("name", query);
        mIView.startNewActivity(SearchResultActivity.class, bundle);
    }
}
