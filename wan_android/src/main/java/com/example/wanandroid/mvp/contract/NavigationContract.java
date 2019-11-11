package com.example.wanandroid.mvp.contract;



import com.example.wanandroid.mvp.contract.base.BaseFragmentContract;
import com.example.wanandroid.mvp.model.bean.DataResponse;
import com.example.wanandroid.mvp.model.bean.Navi;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public interface NavigationContract extends BaseFragmentContract {
    abstract class NavigationPresenter extends BaseFragmentPresenter<INavigationModel, INavigationView, Navi> {

        public abstract void OnTabFlowLayoutItemClick(int position, List<Navi.ArticlesBean> mArticles);

    }

    interface INavigationModel extends BaseFragmentContract.IBaseFragmentModel {
        Observable<DataResponse<List<Navi>>> getNavigation();
    }

    interface INavigationView extends IBaseFragmentView<Navi> {
    }
}
