package com.example.myapplication.mvp.presenter.personal;

import android.util.Log;

import com.example.myapplication.api.wanAndroid;
import com.example.myapplication.mvp.contract.LoginContract;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.User;
import com.example.myapplication.mvp.model.personal.LoginModel;
import com.example.mylibrary.helper.RetrofitCreateHelper;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public class LoginPresenter extends LoginContract.LoginPresenter {
    public static LoginPresenter newInstance() {

        return new LoginPresenter();
    }

    @Override
    public LoginContract.ILoginModel getModel() {
        return LoginModel.newInstance();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void loadMoreList() {

    }

    @Override
    public void loadLatestList() {

    }

    @Override
    public void OnItemClick(int position, User item) {

    }

    @Override
    public void login(String userName, String userPassword) {
//        RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).login("fish_pzb", "45462311a")
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
                            mIView.loginSuccess(value.getData());
                        } else {
                            mIView.loginFail();
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
}
