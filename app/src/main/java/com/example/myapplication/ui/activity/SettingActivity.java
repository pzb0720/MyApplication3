package com.example.myapplication.ui.activity;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.ui.fragment.SettingFragment;
import com.example.mylibrary.base.ui.activity.BaseActivity;


/**
 * Created by Administrator on 2018/11/29 0029.
 */

public class SettingActivity extends BaseActivity {
    @Override
    protected void initView(Bundle savedInstanceState) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, SettingFragment.newInstance(), "setting").commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }
}
