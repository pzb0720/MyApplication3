package com.example.wanandroid.mvp.model.personal;


import com.example.wanandroid.api.wanAndroid;
import com.example.wanandroid.mvp.contract.AddToDoContract;
import com.example.wanandroid.mvp.model.bean.DataResponse;
import com.example.mylibrary.helper.RetrofitCreateHelper;
import com.example.mylibrary.helper.RxHelper;

import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/12/8 0008.
 */

public class AddToDoModel implements AddToDoContract.IAddToDoModel {
    public static AddToDoModel newInstance() {
        return new AddToDoModel();
    }

    @Override
    public Observable<DataResponse> addToDo(Map<String, Object> map) {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).toAddToDo( map).compose(RxHelper.<DataResponse>rxSchedulerHelper());
    }

    @Override
    public Observable<DataResponse> updateToDo(int id, Map<String, Object> map) {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).updateTodo(id, map).compose(RxHelper.<DataResponse>rxSchedulerHelper());
    }
}
