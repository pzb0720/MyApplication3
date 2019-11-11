package com.example.wanandroid.mvp.contract;





import com.example.wanandroid.mvp.contract.base.BaseFragmentContract;
import com.example.wanandroid.mvp.model.bean.Article;
import com.example.wanandroid.mvp.model.bean.ArticleDataBean;
import com.example.wanandroid.mvp.model.bean.DataResponse;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2018/6/29 0029.
 */

public interface ArticleListContract extends BaseFragmentContract {
    abstract class ArticleListPresenter extends BaseFragmentContract.BaseFragmentPresenter<IArticleListModel, IArticleListView, ArticleDataBean> {
        public abstract  void getTreeArticleList(int cid);

        public abstract void addCollection(int position, ArticleDataBean item);

    }

    interface IArticleListModel extends IBaseFragmentModel {
        Observable<DataResponse<Article>> getTreeArticle(int currentPage, int cid);
    }

    interface IArticleListView extends IBaseFragmentView {
        void updateContent(List<ArticleDataBean> list);

        void showAddCollectionSuccess(int position, ArticleDataBean item);
        void showRemoveCollectionSuccess(int position, ArticleDataBean item);
    }
}
