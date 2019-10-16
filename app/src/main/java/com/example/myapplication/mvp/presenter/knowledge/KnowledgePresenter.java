package com.example.myapplication.mvp.presenter.knowledge;


import android.os.Bundle;

import com.example.myapplication.constant.BundleKeyConstant;
import com.example.myapplication.mvp.contract.KnowledgeContract;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.Tree;
import com.example.myapplication.mvp.model.knowledge.KnowledgeModel;
import com.example.myapplication.ui.activity.KnowledgeDetailActivity;

import java.io.Serializable;
import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/6/21 0021.
 */

public class KnowledgePresenter extends KnowledgeContract.KnowledgePresenter {

    public static KnowledgePresenter newInstance() {
        return new KnowledgePresenter();
    }

    @Override
    public KnowledgeContract.IKnowledgeModel getModel() {
        return KnowledgeModel.newInstance();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void loadMoreList() {

    }

    @Override
    public void loadLatestList() {
        mRxManager.register(mIModel.getTree().subscribe(new Consumer<DataResponse<List<Tree>>>() {
            @Override
            public void accept(DataResponse<List<Tree>> data) throws Exception {
                List<Tree> dataBeans = data.getData();
                mIView.updateContentList(dataBeans);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mIView.showToast(throwable.getMessage());
            }
        }));
    }

    @Override
    public void OnItemClick(int position, Tree item) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(BundleKeyConstant.ARG_KEY_LIST, (Serializable) item.getChildren());
        bundle.putString(BundleKeyConstant.ARG_KEY_TITLE, item.getName());
        mIView.startNewActivity(KnowledgeDetailActivity.class, bundle);
    }
}
