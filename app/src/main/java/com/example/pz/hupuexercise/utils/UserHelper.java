package com.example.pz.hupuexercise.utils;

import android.content.Context;

import com.example.pz.hupuexercise.login.model.model.LoginInfo;

/**
 * Created by pz on 2016/8/29.
 */

public class UserHelper {

    static Context mContext;
    static LoginInfo loginInfo;
    static UserHelper userHelper;

    private UserHelper() {}

    public static UserHelper instanceOf(Context Context) {
        mContext = Context;
        userHelper = new UserHelper();
        loginInfo = PrefUtil.getLoginInfo(mContext);
        return userHelper;
    }

    public boolean isLogin() {
        if(loginInfo != null) {
            return true;
        }
        return false;
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

}
