package com.example.wanandroid.mvp.contract;



import com.example.wanandroid.mvp.contract.base.BaseActivityContract;
import com.example.wanandroid.mvp.model.bean.DoneList;
import com.example.wanandroid.mvp.model.bean.ToDo;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/11/28 0028.
 */

public interface ToDoContract {
    abstract class ToDoPresenter extends BaseActivityContract.BaseActivityPresenter<IToDoModel, ITodoView, ToDo.DataBean.DatasBean> {
        public abstract void getToDoData(int page);
        public abstract void addTodo( );

    }

    interface IToDoModel extends BaseActivityContract.IBaseActivityModel {
        Observable<DoneList> getDoneList();

        Observable<ToDo> getTodoList(int page);


    }

    interface ITodoView extends BaseActivityContract.IBaseActivityView {

        void removeItem(int position);


    }
}
