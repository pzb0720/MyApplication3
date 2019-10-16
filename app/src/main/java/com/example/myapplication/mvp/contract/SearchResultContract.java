package com.example.myapplication.mvp.contract;



import com.example.myapplication.mvp.contract.base.BaseActivityContract;
import com.example.myapplication.mvp.model.bean.Article;
import com.example.myapplication.mvp.model.bean.ArticleDataBean;
import com.example.myapplication.mvp.model.bean.DataResponse;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/12/14 0014.
 */

public interface SearchResultContract {
    abstract class SearchResultPresenter extends BaseActivityContract.BaseActivityPresenter<ISearchResultModel, ISearchResultView, ArticleDataBean> {
        public abstract void loadLatestList(String k);

        public abstract void loadMoreList(String k);

        public abstract void addCollection(int position, ArticleDataBean item);

    }

    interface ISearchResultModel extends BaseActivityContract.IBaseActivityModel {
        Observable<DataResponse<Article>> getSearchArticles(int page, String k);
    }

    interface ISearchResultView extends BaseActivityContract.IBaseActivityView {
        void showAddCollectionSuccess(int position, ArticleDataBean item);

        void showRemoveCollectionSuccess(int position, ArticleDataBean item);
    }
}
