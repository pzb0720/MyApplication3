package com.example.wanandroid.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wanandroid.R;
import com.example.wanandroid.constant.RxBusCode;
import com.example.wanandroid.constant.SpConstant;
import com.example.wanandroid.mvp.contract.PersonalContract;
import com.example.wanandroid.mvp.model.bean.Coin;
import com.example.wanandroid.mvp.model.bean.User;
import com.example.wanandroid.mvp.presenter.personal.PersonalPresenter;
import com.example.mylibrary.base.ui.BasePresenter;
import com.example.mylibrary.base.ui.fragment.BaseMVPFragment;
import com.example.mylibrary.helper.cookies.CookiesManager;
import com.example.mylibrary.rxbus.RxBus;
import com.example.mylibrary.rxbus.Subscribe;
import com.example.mylibrary.util.AppUtils;
import com.example.mylibrary.util.SpUtils;

import java.util.List;

import butterknife.BindView;
import okhttp3.Cookie;

/**
 * Created by Administrator on 2018/11/26 0026.
 */

public class PersonalFragment extends BaseMVPFragment<PersonalContract.PersonalPresenter> implements PersonalContract.IPersonalView, View.OnClickListener {
    //public class PersonalFragment extends BaseFragment implements View.OnClickListener{
    @BindView(R.id.civAvatar)
    ImageView mCivAvatar;
    @BindView(R.id.tvNick)
    TextView mTvNick;
    @BindView(R.id.tvMyCollection)
    TextView mTvMyCollection;
    @BindView(R.id.tvMyBookmark)
    TextView mTvMyBookmark;
    @BindView(R.id.tvSetting)
    TextView mTvSetting;
    @BindView(R.id.llLogout)
    LinearLayout mLlLogout;

    @BindView(R.id.ll_current_coin)
    LinearLayout mLlCurrentCoin;
    @BindView(R.id.tv_current_coin)
    TextView mTvCurrentCoin;

    boolean isLogin = false;

    Coin mCoin = new Coin();

    public static PersonalFragment newInstance() {
        Bundle args = new Bundle();
        PersonalFragment fragment = new PersonalFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_personal;
    }

    @Override
    public void initData() {
        super.initData();
        RxBus.get().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unRegister(this);
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {

        mCivAvatar.setOnClickListener(this);
        mTvMyCollection.setOnClickListener(this);
        mLlLogout.setOnClickListener(this);
        mTvSetting.setOnClickListener(this);
        mTvMyBookmark.setOnClickListener(this);
        mLlCurrentCoin.setOnClickListener(this);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

        mPresenter.checkIsLogin();
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return PersonalPresenter.newInstance();
    }

    @Override
    public void updateLatest(boolean value) {
        if (value) {
            String userName = SpUtils.getString(AppUtils.getContext(), SpConstant.SP_USER_NAME, "");
            mTvNick.setText(userName);
            isLogin = true;
//        RxBus.get().send().
            mPresenter.getUserCoin();
            mLlLogout.setVisibility(View.VISIBLE);
        } else {
            isLogin = false;
            mTvNick.setText(R.string.click_avatar_login);
            mLlLogout.setVisibility(View.GONE);
        }

    }

    @Override
    public void updateContentList(List<User> list) {

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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.civAvatar:

                if (!isLogin) {
                    mPresenter.checkLogin();
                }
                break;
            case R.id.ll_current_coin:
                if (isLogin && mCoin != null) {
                    mPresenter.openUserCoinActivity(mCoin);
                } else {
                    showToast("请先登录");
                    mPresenter.checkIsLogin();
                }
                break;
            case R.id.llLogout:
                loginOut();
                break;
            case R.id.tvMyCollection:
                if (isLogin) {
                    mPresenter.collection();
                } else {
                    showToast("请先登录");
                    mPresenter.checkIsLogin();
                }
                break;
            case R.id.tvSetting:
                mPresenter.openSettingActivity();
                break;
            case R.id.tvMyBookmark:
                if (isLogin) {
                    mPresenter.openToDoActivity();
                } else {
                    showToast("请先登录");
                    mPresenter.checkIsLogin();
                }
                break;
            default:
                break;
        }
    }

    private void loginOut() {
//        mPresenter.
        SpUtils.putBoolean(getContext(), SpConstant.SP_USER_LOGIN, false);
        SpUtils.putString(getContext(), SpConstant.SP_USER_NAME, "");
        SpUtils.putString(getContext(), SpConstant.SP_USER_PASSWORD, "");
        isLogin = false;
        updateLatest(isLogin);
        CookiesManager.clearAllCookies();
        List<Cookie> cookies = CookiesManager.getCookies();

        RxBus.get().send(RxBusCode.RX_BUS_CODE_UN_LOGIN);
    }

    @Subscribe(code = RxBusCode.RX_BUS_CODE_LOGIN)
    public void rxBusEvent() {
        Boolean isLogin = SpUtils.getBoolean(AppUtils.getContext(), SpConstant.SP_USER_LOGIN, false);
        updateLatest(isLogin);
    }

    @Override
    public void showUserCoin(Coin coin) {
        int coinCount = coin.getCoinCount();
        mCoin = coin;
        mTvCurrentCoin.setText(coinCount + "");
    }
}
