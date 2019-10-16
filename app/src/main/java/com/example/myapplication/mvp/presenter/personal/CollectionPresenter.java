package com.example.myapplication.mvp.presenter.personal;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.constant.BundleKeyConstant;
import com.example.myapplication.mvp.contract.CollectionContract;
import com.example.myapplication.mvp.model.bean.Collection;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.personal.CollectionModel;
import com.example.myapplication.ui.activity.webView.HomeWebViewActivity;
import com.example.myapplication.util.ArticleCollectionUtils;
import com.example.myapplication.util.UpdateItemTypeUtil;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public class CollectionPresenter extends CollectionContract.CollectionPresenter {

    int mPage = 0;

    public static CollectionPresenter newInstance() {

        return new CollectionPresenter();
    }

    @Override
    public CollectionContract.ICollectionModel getModel() {
        return CollectionModel.newInstance();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void getCollection() {

    }

    @Override
    public void addCollection(int position, Collection.DatasBean item) {
        ArticleCollectionUtils.ActivityArticleCollection(position, item, mIView);
    }

    @Override
    public void loadMoreList() {

    }

    @Override
    public void loadLatestList() {
        mRxManager.register(mIModel.getCollectionArticle(mPage).subscribe(new Consumer<DataResponse<Collection>>() {
            @Override
            public void accept(DataResponse<Collection> collectionArticle) throws Exception {
                if (collectionArticle.getErrorCode() == 0) {
                    mPage++;
                    List<Collection.DatasBean> datas = collectionArticle.getData().getDatas();
//                    Log.i("哇哈哈", "datas" + datas.size());
                    datas = UpdateItemTypeUtil.updateCollectItemType(datas);
                    mIView.updateContentList(datas);
                } else {
                    mIView.showToast(collectionArticle.getErrorMsg().toString());
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
    public void OnItemClick(int position, Collection.DatasBean item) {
        Bundle bundle = new Bundle();
        bundle.putString(BundleKeyConstant.ARG_KEY_TITLE, item.getTitle());
        bundle.putString(BundleKeyConstant.ARG_KEY_URL, item.getLink());
        Log.i("哇哈哈", "item   " + item.getLink() + "   @+@ " + item.getTitle());
        mIView.startNewActivity(HomeWebViewActivity.class, bundle);
    }
}
