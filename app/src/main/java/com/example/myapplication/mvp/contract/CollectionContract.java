package com.example.myapplication.mvp.contract;



import com.example.myapplication.mvp.contract.base.BaseActivityContract;
import com.example.myapplication.mvp.model.bean.Collection;
import com.example.myapplication.mvp.model.bean.DataResponse;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public interface CollectionContract {
    abstract class CollectionPresenter extends BaseActivityContract.BaseActivityPresenter<ICollectionModel, ICollectionView, Collection.DatasBean> {
        public abstract void getCollection();

        public abstract void addCollection(int position, Collection.DatasBean item);
    }

    interface ICollectionModel extends BaseActivityContract.IBaseActivityModel {
        Observable<DataResponse<Collection>> getCollectionArticle(int page);
    }

    interface ICollectionView extends BaseActivityContract.IBaseActivityView {
        void showAddCollectionSuccess(int position, Collection.DatasBean item);

        void showRemoveCollectionSuccess(int position, Collection.DatasBean item, int originId);
    }
}
