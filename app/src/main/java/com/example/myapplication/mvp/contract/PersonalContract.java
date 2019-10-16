package com.example.myapplication.mvp.contract;


import com.example.myapplication.mvp.contract.base.BaseFragmentContract;
import com.example.myapplication.mvp.model.bean.Rank;
import com.example.myapplication.mvp.model.bean.User;

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
    }

    interface IPersonalModel extends BaseFragmentContract.IBaseFragmentModel {
        Observable<Rank> getRank();
    }

    interface IPersonalView extends IBaseFragmentView<User> {
        void updateLatest(boolean isLogin);

        void showUserCoin(int coinCount);
    }
}
