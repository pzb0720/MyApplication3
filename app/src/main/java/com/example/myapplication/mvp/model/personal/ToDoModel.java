package com.example.myapplication.mvp.model.personal;


import com.example.myapplication.api.wanAndroid;
import com.example.myapplication.mvp.contract.ToDoContract;
import com.example.myapplication.mvp.model.bean.DoneList;
import com.example.myapplication.mvp.model.bean.ToDo;
import com.example.mylibrary.helper.RetrofitCreateHelper;
import com.example.mylibrary.helper.RxHelper;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/11/28 0028.
 */

public class ToDoModel implements ToDoContract.IToDoModel {
    public static ToDoModel newInstance() {
        return new ToDoModel();
    }


    @Override
    public Observable<DoneList> getDoneList() {
        return null;
    }

    @Override
    public Observable<ToDo> getTodoList(int page) {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getTodoData(page).compose(RxHelper.<ToDo>rxSchedulerHelper());
    }
}
