package com.example.wanandroid.mvp.contract.base;



import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.IBaseActivity;
import com.example.mylibrary.base.ui.IBaseModel;

import java.util.List;

/**
 * Created by Administrator on 2018/6/28 0028.
 */

public interface BaseActivityContract {
    abstract class BaseActivityPresenter<M extends IBaseActivityModel, V extends IBaseActivityView,T> extends BasePresenter<M, V> {
        /**
         * 加载更多
         */
        public abstract void loadMoreList();

        /**
         * 加载最新
         */
        public abstract void loadLatestList();

        /**
         * item 点击事件
         *
         * @param position
         * @param item
         */
        public abstract void OnItemClick(int position, T item);
    }

    interface IBaseActivityModel extends IBaseModel {


    }

    interface IBaseActivityView<L> extends IBaseActivity {


        /**
         * 更新list
         *
         * @param list
         */
        void updateContentList(List<L> list);

        /**
         * 点击时间更新list
         *
         * @param id
         */
        void itemNotifyChanged(int id);

        /**
         * 显示网络错误
         */
        void showNetworkError();

        /**
         * 显示加载错误
         */
        void showLoadMoreError();

        /**
         * 显示没有更多数据加载
         */
        void showNoMoreData();
    }


}
