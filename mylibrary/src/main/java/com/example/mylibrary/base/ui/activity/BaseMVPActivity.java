package com.example.mylibrary.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.IBaseActivity;
import com.example.mylibrary.util.ToastUtils;
import com.orhanobut.logger.Logger;


/**
 * Created by Administrator on 2018/8/27 0027.
 */

public abstract class BaseMVPActivity<P extends BasePresenter> extends BaseActivity implements IBaseActivity {

    protected P mPresenter;

    @Override
    public void initData() {
        super.initData();

        mPresenter = (P) initPresenter();
        if (mPresenter != null) {
            mPresenter.attachMV(this);
            Logger.d("attach M V success.");
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachMV();
//            Logger.d("detach M V success.");
        }
    }

    @Override
    public void showWaitDialog(String waitMsg) {
        showProgressDialog(waitMsg);
    }

    @Override
    public void hideWaitDialog() {
        hideWaitDialog();
    }

    @Override
    public void hideKeybord() {
        hiddenKeyboard();
    }

    @Override
    public void back() {
        super.onBackPressedSupport();
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public void startNewActivity(@NonNull Class<?> clz) {
        startActivity(clz);
    }

    @Override
    public void startNewActivity(@NonNull Class<?> clz, Bundle bundle) {
        startActivity(clz, bundle);
    }

    @Override
    public void startNewActivityForResult(@NonNull Class<?> clz, Bundle bundle, int requestCode) {
        startNewActivityForResult(clz, bundle, requestCode);
    }
}
