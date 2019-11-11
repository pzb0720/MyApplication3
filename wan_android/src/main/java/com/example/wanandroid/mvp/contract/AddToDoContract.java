package com.example.wanandroid.mvp.contract;


import com.example.wanandroid.mvp.model.bean.DataResponse;
import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.IBaseActivity;
import com.example.mylibrary.base.ui.IBaseModel;

import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/12/8 0008.
 */

public interface AddToDoContract {
    abstract class AddToDoPresenter extends BasePresenter<IAddToDoModel, IAddToDoView> {

        public abstract  void addToDo( Map<String, Object> map);
        public abstract  void updateToDo(int id, Map<String, Object> map);
    }

    interface IAddToDoModel extends IBaseModel {
        Observable<DataResponse> addToDo(Map<String, Object> map);
        Observable<DataResponse> updateToDo(int id, Map<String, Object> map);
    }

    interface IAddToDoView extends IBaseActivity {

    }

}
