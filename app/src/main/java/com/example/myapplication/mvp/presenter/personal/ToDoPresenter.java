package com.example.myapplication.mvp.presenter.personal;

import android.os.Bundle;

import com.example.myapplication.mvp.contract.ToDoContract;
import com.example.myapplication.mvp.model.bean.ToDo;
import com.example.myapplication.mvp.model.personal.ToDoModel;
import com.example.myapplication.ui.activity.AddToDoActivity;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/11/28 0028.
 */

public class ToDoPresenter extends ToDoContract.ToDoPresenter {
    public static final String TAG = "哇哈哈";

    String currentCompleteDate = null;
    int listSize = 0;
    int breakI;


    int currentPage = 0;
    int pageCount = 0;

    public static ToDoPresenter newInstance() {
        return new ToDoPresenter();
    }


    @Override
    public void loadMoreList() {

    }

    @Override
    public void loadLatestList() {

    }

    @Override
    public void OnItemClick(int position, ToDo.DataBean.DatasBean item) {
        Bundle bundle = new Bundle();
        bundle.putInt("status", item.getStatus());
        bundle.putInt("type", item.getType());
        bundle.putString("title", item.getTitle());
        bundle.putString("content", item.getContent());
        bundle.putString("time", item.getDateStr());
        bundle.putInt("id", item.getId());
        bundle.putInt("priority", item.getPriority());
        mIView.startNewActivity(AddToDoActivity.class, bundle);
    }


    @Override
    protected ToDoContract.IToDoModel getModel() {
        return ToDoModel.newInstance();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void getToDoData(final int page) {
        if (mIModel == null || mIView == null) {
            return;
        }

        mRxManager.register(mIModel.getTodoList(page).subscribe(new Consumer<ToDo>() {
            @Override
            public void accept(ToDo toDo) throws Exception {
                currentPage = toDo.getData().getCurPage();
                pageCount = toDo.getData().getPageCount();
                mIView.updateContentList(toDo.getData().getDatas());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mIView.showToast(throwable.getMessage());
                mIView.showLoadMoreError();
            }
        }));
    }

    @Override
    public void addTodo() {
        mIView.startNewActivity(AddToDoActivity.class);
    }


    public int getCurrentPage() {
        return currentPage;
    }
}
