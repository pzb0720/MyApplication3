package com.example.myapplication.mvp.model.personal;


import com.example.myapplication.mvp.contract.PersonalContract;

/**
 * Created by Administrator on 2018/11/29 0029.
 */

public class PersonalModel implements PersonalContract.IPersonalModel {
    public static PersonalModel newInstance() {
        return new PersonalModel();
    }
}
