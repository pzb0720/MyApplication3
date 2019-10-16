package com.example.myapplication.mvp.contract;



import com.example.myapplication.mvp.contract.base.BaseFragmentContract;
import com.example.myapplication.mvp.model.bean.Article;
import com.example.myapplication.mvp.model.bean.ArticleDataBean;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.TopArticle;
import com.example.myapplication.mvp.model.bean.WanBanner;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/6/21 0021.
 */

public interface HomeContract extends BaseFragmentContract {
    abstract class HomePresenter extends BaseFragmentPresenter<IHomeModel, IHomeView, ArticleDataBean> {
        public abstract void loadBanner();

        public abstract void addCollection(int position, ArticleDataBean item);

        public abstract void updateLatestList();

        public abstract void loadAllList(boolean isRefresh);
    }

    interface IHomeModel extends IBaseFragmentModel {
        Observable<DataResponse<Article>> getArticle(int curPage);

        Observable<WanBanner> getBanner();


        Observable<TopArticle> getTopList();
    }

    interface IHomeView extends IBaseFragmentView<ArticleDataBean> {
        void updateBanner(WanBanner banners);

        void updateLatestList(List<ArticleDataBean> list, boolean isRefresh);
//
        void showAddCollectionSuccess(int position, ArticleDataBean item);
//
        void showRemoveCollectionSuccess(int position, ArticleDataBean item);
//
//        void showTopList(List<Article.DataBean.DatasBean> list);
    }
}
