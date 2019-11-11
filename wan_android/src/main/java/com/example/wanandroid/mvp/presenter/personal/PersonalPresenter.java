package com.example.wanandroid.mvp.presenter.personal;


import android.os.Bundle;
import android.util.Log;

import com.example.wanandroid.constant.SpConstant;
import com.example.wanandroid.mvp.contract.PersonalContract;
import com.example.wanandroid.mvp.model.bean.Coin;
import com.example.wanandroid.mvp.model.bean.DataResponse;
import com.example.wanandroid.mvp.model.bean.User;
import com.example.wanandroid.mvp.model.personal.PersonalModel;
import com.example.wanandroid.ui.activity.CoinRankActivity;
import com.example.wanandroid.ui.activity.CollectionActivity;
import com.example.wanandroid.ui.activity.LoginActivity;
import com.example.wanandroid.ui.activity.SettingActivity;
import com.example.wanandroid.ui.activity.ToDoActivity;
import com.example.mylibrary.util.AppUtils;
import com.example.mylibrary.util.SpUtils;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public class PersonalPresenter extends PersonalContract.PersonalPresenter {
    public static final String TAG = "哇哈哈, PersonalPresenter";

    public static PersonalPresenter newInstance() {

        return new PersonalPresenter();
    }

    @Override
    public PersonalContract.IPersonalModel getModel() {
        return PersonalModel.newInstance();
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
    public void checkLogin() {
//        String userName = SpUtils.getString(AppUtils.getContext(), SpConstant.SP_USER_NAME, "");
//        String userPassword = SpUtils.getString(AppUtils.getContext(), SpConstant.SP_USER_PASSWORD, "");
//        if (StringUtils.isEmpty(userName) || userPassword.isEmpty()) {
//            mIView.showToast("用户名或密码不能为空");
//            return;
////            mIView.startNewActivity(LoginActivity.class);
//        } else {
//            mIView.startNewActivity(LoginActivity.class);
//        }
        if (!SpUtils.getBoolean(AppUtils.getContext(), SpConstant.SP_USER_LOGIN, false)) {
            mIView.startNewActivity(LoginActivity.class);
        }
    }

    @Override
    public void checkIsLogin() {
        Boolean isLogin = SpUtils.getBoolean(AppUtils.getContext(), SpConstant.SP_USER_LOGIN, false);
        mIView.updateLatest(isLogin);

    }

    @Override
    public void collection() {
        mIView.startNewActivity(CollectionActivity.class);
    }

    @Override
    public void openSettingActivity() {
        mIView.startNewActivity(SettingActivity.class);
    }

    @Override
    public void openToDoActivity() {
        mIView.startNewActivity(ToDoActivity.class);
    }

    @Override
    public void getUserCoin() {
        mIModel.getUserCoin().subscribe(new Consumer<DataResponse<Coin>>() {
            @Override
            public void accept(DataResponse<Coin> coin) throws Exception {
                mIView.showUserCoin(coin.getData());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mIView.showToast(throwable.getMessage());
                Log.i(TAG, "throwable" + throwable.getMessage());
            }
        });
    }

    @Override
    public void openUserCoinActivity(Coin mCoin) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("coin", mCoin);
        mIView.startNewActivity(CoinRankActivity.class, bundle);
    }
}