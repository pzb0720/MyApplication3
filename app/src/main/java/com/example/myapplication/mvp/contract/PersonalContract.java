package com.example.myapplication.mvp.contract;


import com.example.myapplication.mvp.contract.base.BaseFragmentContract;
import com.example.myapplication.mvp.model.bean.User;

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
    }

    interface IPersonalModel extends BaseFragmentContract.IBaseFragmentModel {

    }

    interface IPersonalView extends IBaseFragmentView<User> {
        void updateLatest(boolean isLogin);
    }
}
