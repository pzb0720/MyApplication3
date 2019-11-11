package com.example.wanandroid.mvp.presenter.personal;

import android.util.Log;

import com.example.wanandroid.mvp.contract.AddToDoContract;
import com.example.wanandroid.mvp.model.bean.DataResponse;
import com.example.wanandroid.mvp.model.personal.AddToDoModel;

import java.util.Map;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/12/8 0008.
 */

public class AddToDoPresenter extends AddToDoContract.AddToDoPresenter {

    public static final String TAG = "哇哈哈";

    public static AddToDoPresenter newInstance() {
        return new AddToDoPresenter();
    }

    @Override
    protected AddToDoContract.IAddToDoModel getModel() {
        return AddToDoModel.newInstance();
    }

    @Override
    public void onStart() {

    }


    @Override
    public void addToDo( Map<String, Object> map) {
        mRxManager.register(mIModel.addToDo( map).subscribe(new Consumer<DataResponse>() {
            @Override
            public void accept(DataResponse baseBean) throws Exception {
                if (baseBean.getErrorCode() == 0) {
                    mIView.showToast("添加完成");
//                    mIView.removeItem(position);
                } else {
                    mIView.showToast("添加失败");
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i(TAG, "throwable : " + throwable.getMessage());
            }
        }));
    }

    @Override
    public void updateToDo(int id,Map<String, Object> map) {
        mRxManager.register(mIModel.updateToDo( id,map).subscribe(new Consumer<DataResponse>() {
            @Override
            public void accept(DataResponse baseBean) throws Exception {
                if (baseBean.getErrorCode() == 0) {
                    mIView.showToast("更新完成");
//                    mIView.removeItem(position);
                } else {
                    mIView.showToast("更新失败");
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i(TAG, "throwable : " + throwable.getMessage());
            }
        }));
    }
}
