package com.example.mylibrary.helper;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/2/25 0025.
 */

public class RxHelper {
    /**
     * 统一线程处理
     * <p>
     * 发布事件io线程，接收事件主线程
     * @param <T>
     * @return
     */
    public static<T> ObservableTransformer<T,T> rxSchedulerHelper() {
        //compos的事件处理进程
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


}
