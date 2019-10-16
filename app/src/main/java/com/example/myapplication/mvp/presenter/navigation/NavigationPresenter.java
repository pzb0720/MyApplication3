package com.example.myapplication.mvp.presenter.navigation;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.constant.BundleKeyConstant;
import com.example.myapplication.mvp.contract.NavigationContract;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.Navi;
import com.example.myapplication.mvp.model.navigation.NavigationModel;
import com.example.myapplication.ui.activity.webView.HomeWebViewActivity;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/6/25 0025.
 */

public class NavigationPresenter extends NavigationContract.NavigationPresenter {

    public static NavigationPresenter newInstance() {
        return new NavigationPresenter();
    }

    @Override
    protected NavigationContract.INavigationModel getModel() {
        return NavigationModel.newInstance();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void loadMoreList() {

    }

    @Override
    public void loadLatestList() {
        mRxManager.register(mIModel.getNavigation().subscribe(new Consumer<DataResponse<List<Navi>>>() {
            @Override
            public void accept(DataResponse<List<Navi>> navi) throws Exception {
                mIView.updateContentList(navi.getData());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i("哇哈哈", "" +throwable.getMessage());
                mIView.showToast(throwable.getMessage());
            }
        }));
    }

    @Override
    public void OnItemClick(int position, Navi item) {

    }

    @Override
    public void OnTabFlowLayoutItemClick(int position, List<Navi.ArticlesBean> mArticles) {
        Bundle bundle = new Bundle();
        bundle.putString(BundleKeyConstant.ARG_KEY_TITLE, mArticles.get(position).getTitle());
        bundle.putString(BundleKeyConstant.ARG_KEY_URL, mArticles.get(position).getLink());

        mIView.startNewActivity(HomeWebViewActivity.class, bundle);
    }
}
