package com.example.myapplication.mvp.contract.base;


import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.IBaseActivity;
import com.example.mylibrary.base.ui.IBaseModel;

/**
 * Created by Administrator on 2018/6/26 0026.
 */

public interface BaseWebViewLoadContract {
    abstract class BaseWebViewLoadPresenter<M extends IBaseWebViewLoadModel, V extends IBaseWebViewLoadView> extends BasePresenter<M, V> {


    }

    interface IBaseWebViewLoadModel extends IBaseModel {

    }

    interface IBaseWebViewLoadView extends IBaseActivity {
        /**
         * 显示网络错误
         */
        void showNetworkError();


    }
}
