package com.example.myapplication.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.constant.RxBusCode;
import com.example.myapplication.constant.SpConstant;
import com.example.myapplication.mvp.contract.LoginContract;
import com.example.myapplication.mvp.model.bean.User;
import com.example.myapplication.mvp.presenter.personal.LoginPresenter;
import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.activity.BaseMVPActivity;
import com.example.mylibrary.helper.cookies.CookiesManager;
import com.example.mylibrary.rxbus.RxBus;
import com.example.mylibrary.util.SpUtils;
import com.example.mylibrary.util.StatusBarUtils;
import com.example.mylibrary.util.StringUtils;
import com.example.mylibrary.util.ToastUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public class LoginActivity extends BaseMVPActivity<LoginContract.LoginPresenter> implements View.OnClickListener, LoginContract.ILoginView {
    @BindView(R.id.etUsername)
    TextInputEditText mEtUsername;
    @BindView(R.id.etPassword)
    TextInputEditText mEtPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.common_toolbar)
    Toolbar toolbar;

    @Override
    protected void initView(Bundle savedInstanceState) {
        StatusBarUtils.setColor(this, getColorPrimary());
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressedSupport();
            }
        });
        btnLogin.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                String username = mEtUsername.getText().toString().trim();
                String password = mEtPassword.getText().toString().trim();
                if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
                    ToastUtils.showToast(R.string.the_username_or_password_can_not_be_empty);
                    return;
                } else {
                    mPresenter.login(username, password);
                }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return LoginPresenter.newInstance();
    }


    @Override
    public void updateContentList(List list) {

    }

    @Override
    public void itemNotifyChanged(int id) {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showLoadMoreError() {

    }

    @Override
    public void showNoMoreData() {

    }

    @Override
    public void loginSuccess(User data) {
        String username = mEtUsername.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        SpUtils.putBoolean(this, SpConstant.SP_USER_LOGIN, true);
        SpUtils.putString(this, SpConstant.SP_USER_NAME, username);
        SpUtils.putString(this, SpConstant.SP_USER_PASSWORD, password);
        showToast("登陆成功");
        CookiesManager manager = new CookiesManager();
        RxBus.get().send(RxBusCode.RX_BUS_CODE_LOGIN);
//        RxBus.get().
        this.finish();
    }

    @Override
    public void loginFail() {
        ToastUtils.showToast("登录失败");
    }
}
