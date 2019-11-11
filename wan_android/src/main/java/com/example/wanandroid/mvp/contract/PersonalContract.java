package com.example.wanandroid.mvp.contract;


import com.example.wanandroid.mvp.contract.base.BaseFragmentContract;
import com.example.wanandroid.mvp.model.bean.Coin;
import com.example.wanandroid.mvp.model.bean.DataResponse;
import com.example.wanandroid.mvp.model.bean.User;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2018/11/29 0029.
 */

public interface PersonalContract extends BaseFragmentContract {
    abstract class PersonalPresenter extends BaseFragmentPresenter<IPersonalModel, IPersonalView, User> {
        public abstract void checkLogin();

        public abstract void checkIsLogin();

        public abstract void collection();

        public abstract void openSettingActivity();

        public abstract void openToDoActivity();

        public abstract void getUserCoin();

        public abstract void openUserCoinActivity(Coin coin);
    }

    interface IPersonalModel extends BaseFragmentContract.IBaseFragmentModel {
        Observable<DataResponse<Coin>> getUserCoin();
    }

    interface IPersonalView extends IBaseFragmentView<User> {
        void updateLatest(boolean isLogin);

        void showUserCoin(Coin coin);
    }
}
