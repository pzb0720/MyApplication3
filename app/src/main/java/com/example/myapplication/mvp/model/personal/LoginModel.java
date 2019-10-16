package com.example.myapplication.mvp.model.personal;


import com.example.myapplication.mvp.contract.LoginContract;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public class LoginModel implements LoginContract.ILoginModel{

    public static LoginModel newInstance() {

        return new LoginModel();
    }}
