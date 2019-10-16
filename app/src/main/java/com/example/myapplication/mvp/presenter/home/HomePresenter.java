package com.example.myapplication.mvp.presenter.home;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.api.wanAndroid;
import com.example.myapplication.constant.BundleKeyConstant;
import com.example.myapplication.mvp.contract.HomeContract;
import com.example.myapplication.mvp.model.bean.Article;
import com.example.myapplication.mvp.model.bean.ArticleDataBean;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.TopArticle;
import com.example.myapplication.mvp.model.bean.User;
import com.example.myapplication.mvp.model.bean.WanBanner;
import com.example.myapplication.mvp.model.home.HomeModel;
import com.example.myapplication.ui.activity.webView.HomeWebViewActivity;
import com.example.myapplication.util.ArticleCollectionUtils;
import com.example.myapplication.util.UpdateItemTypeUtil;
import com.example.mylibrary.helper.RetrofitCreateHelper;
import com.example.mylibrary.helper.RxHelper;
import com.example.mylibrary.util.SpUtils;
import com.example.mylibrary.util.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function3;
import io.reactivex.schedulers.Schedulers;

import static com.example.myapplication.constant.SpConstant.SP_USER_LOGIN;
import static com.example.myapplication.constant.SpConstant.SP_USER_NAME;
import static com.example.myapplication.constant.SpConstant.SP_USER_PASSWORD;


public class HomePresenter extends HomeContract.HomePresenter {
    int curPage = 0;
    private static final String TAG = "哇哈哈";

    private boolean isFirst = true;

    Observable<WanBanner> bannerBean = RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getBanner();
    Observable<DataResponse<Article>> articleBean = RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getArticle(curPage);
    Observable<TopArticle> topBean = RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getTop();

    public static HomePresenter newInstance() {
        return new HomePresenter();
    }

    @Override
    public void loadBanner() {
        mRxManager.register(mIModel.getBanner().subscribe(new Consumer<WanBanner>() {
            @Override
            public void accept(WanBanner wanBanner) throws Exception {
                mIView.updateBanner(wanBanner);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i(TAG, "accept: " + throwable.getMessage());
            }
        }));

    }

    @Override
    public void addCollection(int position, ArticleDataBean item) {
        ArticleCollectionUtils.ArticleCollection(position, item, mIView);
    }

    @Override
    public void updateLatestList() {
        curPage = 0;
        loadUpdateList();
    }

    private void loadUpdateList() {
    }


    @Override
    public void loadAllList(boolean isRefresh) {
        if (SpUtils.getBoolean(mIView.getBindActivity(), SP_USER_LOGIN, false)) {
            if (isFirst) {
                login();
            }
        }
        loadTopList(isRefresh);
    }

    private void login() {

        String userName = SpUtils.getString(mIView.getBindActivity(), SP_USER_NAME, "");
        String userPassword = SpUtils.getString(mIView.getBindActivity(), SP_USER_PASSWORD, "");

        RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).login(userName, userPassword)
                .subscribeOn(Schedulers.io()) //被观察者线程
                .observeOn(AndroidSchedulers.mainThread())//观察者线程
                .subscribe(new Observer<DataResponse<User>>() {  //订阅
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataResponse<User> value) {
                        Log.i("", "value.errcode" + value.getErrorCode());
                        if (value.getErrorCode() == 0) {
                            Log.i("哇哈哈", "value.data" + value.getData().getUsername() + "@@@@@@@@@@@@" + value.getData().getPassword());
                            isFirst = false;
                            mIView.showToast("自动登陆成功");

                        } else {
                            mIView.showToast("自动登陆失败");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mIView.showToast(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    private void loadTopList(final boolean isRefresh) {


        Observable.zip(bannerBean, articleBean, topBean, new Function3<WanBanner, DataResponse<Article>, TopArticle, Map<String, Object>>() {
            @Override
            public Map<String, Object> apply(WanBanner wanBanner, DataResponse<Article> articleDataResponse, TopArticle topArticle) throws Exception {
                Map<String, Object> objMap = new HashMap<>();
                objMap.put("BANNER", wanBanner);
                objMap.put("ARTICLE", articleDataResponse);
                objMap.put("TOP", topArticle);

                return objMap;
            }
        }).compose(RxHelper.<Map<String, Object>>rxSchedulerHelper()).subscribe(new Consumer<Map<String, Object>>() {
            @Override
            public void accept(Map<String, Object> map) throws Exception {
                WanBanner wanBanner = (WanBanner) map.get("BANNER");
                DataResponse<Article> articleDataResponse = (DataResponse<Article>) map.get("ARTICLE");
                TopArticle topArticle = (TopArticle) map.get("TOP");
                mIView.updateBanner(wanBanner);

                List<ArticleDataBean> dataBeans = new ArrayList<>();
                dataBeans.addAll(topArticle.getData());
                dataBeans.addAll(articleDataResponse.getData().getDatas());

//                for (ArticleDataBean dataBean : dataBeans) {
//                    if (TextUtils.isEmpty(dataBean.getEnvelopePic())) {
//                        dataBean.setItemType(ArticleAdapter.ARTICLE);
//                    } else {
//                        dataBean.setItemType(ArticleAdapter.PROJECT);
//                    }
//                }
                dataBeans = UpdateItemTypeUtil.updateArticleItemType(dataBeans);

//                if (isRefresh) {
//                    mIView.updateLatestList(dataBeans,isRefresh);
//                } else {
//                    mIView.updateContentList(dataBeans);
//                }
                mIView.updateLatestList(dataBeans, isRefresh);

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mIView.showToast(throwable.getMessage());
                Log.i("哇哈哈", "throwable " + throwable.getMessage());
                mIView.showLoadMoreError();
            }
        });
    }

    @Override
    public void loadMoreList() {
        mRxManager.register(mIModel.getArticle(curPage).subscribe(new Consumer<DataResponse<Article>>() {
            @Override
            public void accept(DataResponse<Article> articleDataResponse) throws Exception {
                curPage = articleDataResponse.getData().getCurPage();
                List<ArticleDataBean> articleDataBeans = articleDataResponse.getData().getDatas();
                articleDataBeans = UpdateItemTypeUtil.updateArticleItemType(articleDataBeans);

                mIView.updateContentList(articleDataBeans);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                ToastUtils.showToast(throwable.getMessage());
            }
        }));
    }


    @Override
    public void loadLatestList() {
        mRxManager.register(mIModel.getArticle(curPage).subscribe(new Consumer<DataResponse<Article>>() {
            @Override
            public void accept(DataResponse<Article> articleDataResponse) throws Exception {
                curPage = articleDataResponse.getData().getCurPage();
                List<ArticleDataBean> articleDataBeans = articleDataResponse.getData().getDatas();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mIView.showNetworkError();
            }
        }));
    }

    @Override
    public void OnItemClick(int position, ArticleDataBean item) {
        Bundle bundle = new Bundle();
        bundle.putString(BundleKeyConstant.ARG_KEY_TITLE, item.getTitle());
        bundle.putString(BundleKeyConstant.ARG_KEY_URL, item.getLink());
        mIView.startNewActivity(HomeWebViewActivity.class, bundle);
    }

    @Override
    protected HomeContract.IHomeModel getModel() {
        return HomeModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
