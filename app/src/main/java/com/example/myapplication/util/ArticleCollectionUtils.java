package com.example.myapplication.util;


import com.example.myapplication.api.wanAndroid;
import com.example.myapplication.constant.SpConstant;
import com.example.myapplication.mvp.contract.CollectionContract;
import com.example.myapplication.mvp.contract.HomeContract;
import com.example.myapplication.mvp.contract.SearchResultContract;
import com.example.myapplication.mvp.contract.base.BaseActivityContract;
import com.example.myapplication.mvp.contract.base.BaseFragmentContract;
import com.example.myapplication.mvp.model.bean.Article;
import com.example.myapplication.mvp.model.bean.ArticleDataBean;
import com.example.myapplication.mvp.model.bean.Collection;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.ui.activity.LoginActivity;
import com.example.mylibrary.helper.RetrofitCreateHelper;
import com.example.mylibrary.helper.RxHelper;
import com.example.mylibrary.util.AppUtils;
import com.example.mylibrary.util.SpUtils;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/7/15 0015.
 */

public class ArticleCollectionUtils {
    public static void ArticleCollection(final int position, final ArticleDataBean item, final BaseFragmentContract.IBaseFragmentView mIView) {

        if (SpUtils.getBoolean(AppUtils.getContext(), SpConstant.SP_USER_LOGIN, false)) {
            //
            if (item.isCollect()) {

                RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).removeCollectArticle(item.getId()).compose(RxHelper.<DataResponse<Article>>rxSchedulerHelper())
                        .subscribe(new Consumer<DataResponse<Article>>() {
                            @Override
                            public void accept(DataResponse<Article> article) throws Exception {
                                if (article.getErrorCode() == 0) {
                                    item.setCollect(false);
                                    if (mIView instanceof HomeContract.IHomeView) {
                                        ((HomeContract.IHomeView) mIView).showRemoveCollectionSuccess(position, item);
                                    }
//                                    else if (mIView instanceof ArticleListContract.IArticleListView) {
//                                        ((ArticleListContract.IArticleListView) mIView).showRemoveCollectionSuccess(position, item);
//                                    }

                                } else {
                                    mIView.showToast("取消收藏失败");
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                mIView.showToast(throwable.getMessage());
                            }
                        });

            } else {
                RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).addCollectArticle(item.getId())
                        .compose(RxHelper.<DataResponse>rxSchedulerHelper()).subscribe(new Consumer<DataResponse>() {
                    @Override
                    public void accept(DataResponse dataResponse) throws Exception {
                        if (dataResponse.getErrorCode() == 0) {
                            item.setCollect(true);
                            if (mIView instanceof HomeContract.IHomeView) {
                                ((HomeContract.IHomeView) mIView).showAddCollectionSuccess(position, item);
                            }
//                            else if (mIView instanceof ArticleListContract.IArticleListView) {
//                                ((ArticleListContract.IArticleListView) mIView).showAddCollectionSuccess(position, item);
//                            }

                        } else {

                            mIView.showToast("收藏失败");
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mIView.showToast("收藏失败" + throwable.getMessage());
                    }
                });

            }
        } else {
            mIView.showToast("请先登录");
            mIView.startNewActivity(LoginActivity.class);
        }
    }

    public static void ArticleCollection(final int position, final ArticleDataBean item, final BaseActivityContract.IBaseActivityView mIView) {

        if (SpUtils.getBoolean(AppUtils.getContext(), SpConstant.SP_USER_LOGIN, false)) {
            //
            if (item.isCollect()) {

                RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).removeCollectArticle(item.getId()).compose(RxHelper.<DataResponse<Article>>rxSchedulerHelper())
                        .subscribe(new Consumer<DataResponse<Article>>() {
                            @Override
                            public void accept(DataResponse<Article> article) throws Exception {
                                if (article.getErrorCode() == 0) {
                                    item.setCollect(false);
                                    if (mIView instanceof SearchResultContract.ISearchResultView) {
                                        ((SearchResultContract.ISearchResultView) mIView).showRemoveCollectionSuccess(position, item);
                                    }

                                } else {
                                    mIView.showToast("取消收藏失败");
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                mIView.showToast(throwable.getMessage());
                            }
                        });

            } else {
                RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).addCollectArticle(item.getId())
                        .compose(RxHelper.<DataResponse>rxSchedulerHelper()).subscribe(new Consumer<DataResponse>() {
                    @Override
                    public void accept(DataResponse dataResponse) throws Exception {
                        if (dataResponse.getErrorCode() == 0) {
                            item.setCollect(true);
                            if (mIView instanceof SearchResultContract.ISearchResultView) {
                                ((SearchResultContract.ISearchResultView) mIView).showAddCollectionSuccess(position, item);
                            }

                        } else {

                            mIView.showToast("收藏失败");
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mIView.showToast("收藏失败" + throwable.getMessage());
                    }
                });

            }
        } else {
            mIView.showToast("请先登录");
            mIView.startNewActivity(LoginActivity.class);
        }
    }

    public static void ActivityArticleCollection(final int position, final Collection.DatasBean item, final BaseActivityContract.IBaseActivityView mIView) {
        if (SpUtils.getBoolean(AppUtils.getContext(), SpConstant.SP_USER_LOGIN, false)) {

            if (item.getOriginId() != -1) {

                RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).removeCollectArticle(item.getId(), -1).compose(RxHelper.<DataResponse<Collection>>rxSchedulerHelper())
                        .subscribe(new Consumer<DataResponse<Collection>>() {
                            @Override
                            public void accept(DataResponse<Collection> article) throws Exception {
                                if (article.getErrorCode() == 0) {
                                    int originId = item.getOriginId();
                                    item.setOriginId(-1);
                                    if (mIView instanceof CollectionContract.ICollectionView) {
                                        ((CollectionContract.ICollectionView) mIView).showRemoveCollectionSuccess(position, item, originId);
                                    }

                                } else {
                                    mIView.showToast("取消收藏失败");
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                mIView.showToast(throwable.getMessage());
                            }
                        });
            }
        } else {
            mIView.showToast("请先登录");
            mIView.startNewActivity(LoginActivity.class);
        }

//            RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).removeCollectArticle(item.getId()).compose(RxHelper.<DataResponse<Article>>rxSchedulerHelper())
//                    .subscribe(new Consumer<DataResponse<Article>>() {
//                        @Override
//                        public void accept(DataResponse<Article> articleDataResponse) throws Exception {
//                            Log.i("哇哈哈", "取消收藏");
//                        }
//                    }, new Consumer<Throwable>() {
//                        @Override
//                        public void accept(Throwable throwable) throws Exception {
//                            Log.i("哇哈哈", "Throwable" + throwable.getMessage());
//                        }
//                    });
//
//        } else {
//            mIView.showToast("请先登录");
//            mIView.startNewActivity(LoginActivity.class);
//        }

    }

}
