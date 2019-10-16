package com.example.myapplication.mvp.model.knowledge;


import com.example.myapplication.api.wanAndroid;
import com.example.myapplication.mvp.contract.KnowledgeContract;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.Tree;
import com.example.mylibrary.helper.RetrofitCreateHelper;
import com.example.mylibrary.helper.RxHelper;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Administrator on 2018/6/21 0021.
 */

public class KnowledgeModel implements KnowledgeContract.IKnowledgeModel {
    public static KnowledgeModel newInstance() {

        return new KnowledgeModel();
    }


    @Override
    public Observable<DataResponse<List<Tree>>> getTree() {
        return RetrofitCreateHelper.createApi(wanAndroid.class, wanAndroid.HOST_URL).getTree().compose(RxHelper.<DataResponse<List<Tree>>>rxSchedulerHelper());
    }
}
