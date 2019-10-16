package com.example.mylibrary.base.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;


import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.IBaseFragment;
import com.example.mylibrary.base.ui.activity.BaseActivity;
import com.example.mylibrary.base.ui.fragment.BaseFragment;
import com.example.mylibrary.util.ToastUtils;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Administrator on 2018/11/26 0026.
 */

public abstract class BaseMVPFragment<P extends BasePresenter> extends BaseFragment implements IBaseFragment {
    public P mPresenter;

    @Override
    public void initData() {
        super.initData();
        mPresenter = (P) initPresenter();
        if(mPresenter!=null){
            mPresenter.attachMV(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.detachMV();
        }
    }
    @Override
    public void showWaitDialog(String msg) {
        showProgressDialog(msg);
    }

    @Override
    public void hideWaitDialog() {
        hideProgressDialog();
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showToast(mContext, msg, Toast.LENGTH_SHORT);
    }
    @Override
    public void back() {
        this.onBackPressedSupport();
    }

    @Override
    public void startNewFragment(@NonNull SupportFragment supportFragment) {
        start(supportFragment);
    }

    @Override
    public void startNewFragmentWithPop(@NonNull SupportFragment supportFragment) {
        startWithPop(supportFragment);
    }

    @Override
    public void startNewFragmentForResult(@NonNull SupportFragment supportFragment, int
            requestCode) {
        startForResult(supportFragment, requestCode);
    }

    @Override
    public void popToFragment(Class<?> targetFragmentClass, boolean includeTargetFragment) {
        popTo(targetFragmentClass, includeTargetFragment);
    }

    @Override
    public void hideKeybord() {
        hideSoftInput();
    }

    @Override
    public void setOnFragmentResult(int ResultCode, Bundle data) {
        setFragmentResult(ResultCode, data);
    }

    @Override
    public void startNewActivity(@NonNull Class<?> clz) {
        ((BaseActivity) mActivity).startActivity(clz);
    }

    @Override
    public void startNewActivity(@NonNull Class<?> clz, Bundle bundle) {
        ((BaseActivity) mActivity).startActivity(clz, bundle);
    }

    @Override
    public void startNewActivityForResult(@NonNull Class<?> clz, Bundle bundle, int requestCode) {
        ((BaseActivity) mActivity).startActivityForResult(clz, bundle, requestCode);
    }

    @Override
    public boolean isVisiable() {
        return isSupportVisible();
    }

    @Override
    public Activity getBindActivity() {
        return mActivity;
    }
}
