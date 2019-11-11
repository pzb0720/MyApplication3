package com.example.wanandroid.mvp.presenter.home;

import android.os.Bundle;
import android.util.Log;

import com.example.wanandroid.constant.BundleKeyConstant;
import com.example.wanandroid.mvp.contract.SearchResultContract;
import com.example.wanandroid.mvp.model.bean.Article;
import com.example.wanandroid.mvp.model.bean.ArticleDataBean;
import com.example.wanandroid.mvp.model.bean.DataResponse;
import com.example.wanandroid.mvp.model.home.SearchResultModel;
import com.example.wanandroid.ui.activity.webView.HomeWebViewActivity;
import com.example.wanandroid.util.ArticleCollectionUtils;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/12/14 0014.
 */

public class SearchResultPresenter extends SearchResultContract.SearchResultPresenter {
    int page = 0;
    int maxPage = 0;

    public static SearchResultPresenter newInstance() {
        return new SearchResultPresenter();
    }

    @Override
    protected SearchResultContract.ISearchResultModel getModel() {
        return SearchResultModel.newInstance();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void loadMoreList() {

    }


    @Override
    public void loadMoreList(String k) {
//        if (page >= maxPage) {
//            mIView.showNoMoreData();
//            return;
//        }
        mRxManager.register(mIModel.getSearchArticles(page, k).subscribe(new Consumer<DataResponse<Article>>() {
            @Override
            public void accept(DataResponse<Article> article) throws Exception {
                if (mIView != null) {
                    page = article.getData().getCurPage();
                    for (int i = 0; i < article.getData().getDatas().size(); i++) {
                        String title = clearTitle(article.getData().getDatas().get(i).getTitle());
                        article.getData().getDatas().get(i).setTitle(title);
                    }
                    mIView.updateContentList(article.getData().getDatas());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mIView.showLoadMoreError();
                mIView.showToast(throwable.getMessage());
            }
        }));


    }

    @Override
    public void addCollection(int position, ArticleDataBean item) {
        ArticleCollectionUtils.ArticleCollection(position, item, mIView);
    }

    @Override
    public void loadLatestList() {

    }

    @Override
    public void loadLatestList(String k) {

        mRxManager.register(mIModel.getSearchArticles(page, k).subscribe(new Consumer<DataResponse<Article>>() {
            @Override
            public void accept(DataResponse<Article> article) throws Exception {
                if (mIView != null) {
                    page = article.getData().getCurPage();
                    maxPage = article.getData().getPageCount();
                    Log.i("哇哈哈", "page " + page + "  maxpage  " + maxPage);
                    for (int i = 0; i < article.getData().getDatas().size(); i++) {
                        String title = clearTitle(article.getData().getDatas().get(i).getTitle());
                        article.getData().getDatas().get(i).setTitle(title);
                    }
                    mIView.updateContentList(article.getData().getDatas());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mIView.showToast(throwable.getMessage());
            }
        }));
    }

    public String clearTitle(String title) {
        String subStr[] = title.split("<em class='highlight'>");
        //第一次删除：
        String firstTitle = "";
        for (int i = 0; i < subStr.length; i++) {
            firstTitle = firstTitle + subStr[i];
        }
        //第二次删除
        String secondTitle = "";
        String subStr2[] = firstTitle.split("</em>");
        for (int i = 0; i < subStr2.length; i++) {
            secondTitle = secondTitle + subStr2[i];
        }
        return secondTitle;
    }


    @Override
    public void OnItemClick(int position, ArticleDataBean item) {
        Bundle bundle = new Bundle();
        bundle.putString(BundleKeyConstant.ARG_KEY_TITLE, item.getTitle());
        bundle.putString(BundleKeyConstant.ARG_KEY_URL, item.getLink());
        mIView.startNewActivity(HomeWebViewActivity.class, bundle);
    }
}
