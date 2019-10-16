package com.example.myapplication.mvp.presenter.knowledge;

import android.os.Bundle;

import com.example.myapplication.constant.BundleKeyConstant;
import com.example.myapplication.mvp.contract.ArticleListContract;
import com.example.myapplication.mvp.model.bean.Article;
import com.example.myapplication.mvp.model.bean.ArticleDataBean;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.knowledge.ArticleListModel;
import com.example.myapplication.ui.activity.webView.HomeWebViewActivity;
import com.example.myapplication.util.UpdateItemTypeUtil;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/6/29 0029.
 */

public class ArticleListPresenter extends ArticleListContract.ArticleListPresenter {

    public int currentPage = 0;
    public int pageCount;
    public int mCid;

    public static ArticleListPresenter newInstance() {
        return new ArticleListPresenter();
    }

    @Override
    public ArticleListContract.IArticleListModel getModel() {
        return ArticleListModel.newInstance();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void loadMoreList() {
        if (pageCount <= currentPage) {
            mIView.showNoMoreData();
            return;

        }
        mRxManager.register(mIModel.getTreeArticle(currentPage, mCid).subscribe(new Consumer<DataResponse<Article>>() {
            @Override
            public void accept(DataResponse<Article> treeArticle) throws Exception {
                currentPage = treeArticle.getData().getCurPage();
//                    mIView.updateContentList(treeArticle.getData().getDatas());
                Article data = treeArticle.getData();
                List<ArticleDataBean> datas = data.getDatas();
                datas = UpdateItemTypeUtil.updateArticleItemType(datas);
                mIView.updateContent(datas);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mIView.showLoadMoreError();
            }
        }));

    }

    @Override
    public void loadLatestList() {

    }

    @Override
    public void OnItemClick(int position, ArticleDataBean item) {
        Bundle bundle = new Bundle();
        bundle.putString(BundleKeyConstant.ARG_KEY_TITLE, item.getTitle());
        bundle.putString(BundleKeyConstant.ARG_KEY_URL, item.getLink());

        mIView.startNewActivity(HomeWebViewActivity.class, bundle);
    }

    @Override
    public void getTreeArticleList(int cid) {
        mCid = cid;
        mRxManager.register(mIModel.getTreeArticle(currentPage, cid).subscribe(new Consumer<DataResponse<Article>>() {
            @Override
            public void accept(DataResponse<Article> treeArticle) throws Exception {

                currentPage = treeArticle.getData().getCurPage();
                pageCount = treeArticle.getData().getPageCount();
                Article data = treeArticle.getData();
                List<ArticleDataBean> datas = data.getDatas();
                datas = UpdateItemTypeUtil.updateArticleItemType(datas);


                mIView.updateContent(datas);
//                mIView.updateContentList(treeArticle.getData().getDatas());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mIView.showNetworkError();
            }
        }));
    }

    @Override
    public void addCollection(int position, ArticleDataBean item) {
//        ArticleCollectionUtils.ArticleCollection(position, item, mIView);
    }
}
