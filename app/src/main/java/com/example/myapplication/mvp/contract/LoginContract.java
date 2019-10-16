package com.example.myapplication.mvp.contract;


import com.example.myapplication.mvp.contract.base.BaseActivityContract;
import com.example.myapplication.mvp.model.bean.User;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public interface LoginContract {
    abstract class LoginPresenter extends BaseActivityContract.BaseActivityPresenter<ILoginModel, ILoginView, User> {
        public abstract void login(String userName,String userPassword);
    }

    interface ILoginModel extends BaseActivityContract.IBaseActivityModel {

    }

    interface ILoginView extends BaseActivityContract.IBaseActivityView {
        void loginSuccess(User data);

        void loginFail();
    }
}
