package com.example.myapplication.mvp.presenter.home;

import android.os.Bundle;

import com.example.myapplication.constant.BundleKeyConstant;
import com.example.myapplication.mvp.contract.HotContract;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.Friend;
import com.example.myapplication.mvp.model.home.HotModel;
import com.example.myapplication.ui.activity.webView.HomeWebViewActivity;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/12/12 0012.
 */

public class HotPresenter extends HotContract.HotPresenter {
    public static HotPresenter newInstance() {

        return new HotPresenter();
    }

    @Override
    protected HotContract.IHotModel getModel() {
        return HotModel.newInstance();
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
        mRxManager.register(mIModel.getFriend().subscribe(new Consumer<DataResponse<List<Friend>>>() {
            @Override
            public void accept(DataResponse<List<Friend>> friend) throws Exception {
                if (mIView != null) {
                    if (friend.getErrorCode() == 0)
                        mIView.updateContentList(friend.getData());
                    else {
                        mIView.showToast(friend.getErrorMsg().toString());
                    }
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mIView.showToast(throwable.getMessage());
                mIView.showNetworkError();
            }
        }));
    }

    @Override
    public void OnItemClick(int position, Friend item) {
        Bundle bundle = new Bundle();
        bundle.putString(BundleKeyConstant.ARG_KEY_TITLE, item.getName());
        bundle.putString(BundleKeyConstant.ARG_KEY_URL, item.getLink());
        mIView.startNewActivity(HomeWebViewActivity.class, bundle);
    }
}
