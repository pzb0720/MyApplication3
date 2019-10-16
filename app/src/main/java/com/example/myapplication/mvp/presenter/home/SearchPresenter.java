package com.example.myapplication.mvp.presenter.home;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.mvp.contract.SearchContract;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.Friend;
import com.example.myapplication.mvp.model.home.SearchModel;
import com.example.myapplication.ui.activity.SearchResultActivity;

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
        ;
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
        Log.i("哇哈哈", "???item.id" + item.getId());
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
}
