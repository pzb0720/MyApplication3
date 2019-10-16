package com.example.myapplication.mvp.contract;



import com.example.myapplication.mvp.contract.base.BaseFragmentContract;
import com.example.myapplication.mvp.model.bean.DataResponse;
import com.example.myapplication.mvp.model.bean.Tree;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/6/21 0021.
 */

public interface KnowledgeContract extends BaseFragmentContract {
    abstract class KnowledgePresenter extends BaseFragmentPresenter<IKnowledgeModel, IKnowledgeView, Tree> {
    }

    interface IKnowledgeModel extends BaseFragmentContract.IBaseFragmentModel {
        Observable<DataResponse<List<Tree>>> getTree();
    }

    interface IKnowledgeView extends IBaseFragmentView<Tree> {
    }
}
