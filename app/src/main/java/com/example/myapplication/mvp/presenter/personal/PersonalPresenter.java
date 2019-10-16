package com.example.myapplication.mvp.presenter.personal;


import android.util.Log;

import com.example.myapplication.constant.SpConstant;
import com.example.myapplication.mvp.contract.PersonalContract;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.Rank;
import com.example.myapplication.mvp.model.bean.User;
import com.example.myapplication.mvp.model.personal.PersonalModel;
import com.example.myapplication.ui.activity.CollectionActivity;
import com.example.myapplication.ui.activity.LoginActivity;
import com.example.myapplication.ui.activity.SettingActivity;
import com.example.myapplication.ui.activity.ToDoActivity;
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
        mIModel.getRank().subscribe(new Consumer<Rank>() {
            @Override
            public void accept(Rank rank) throws Exception {
                Log.i(TAG, "accept: ");
                mIView.showUserCoin(rank.getData().getCoinCount());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i(TAG, "accept: " + throwable.getMessage());
            }
        });
    }
}