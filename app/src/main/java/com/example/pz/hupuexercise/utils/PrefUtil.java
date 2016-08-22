package com.example.pz.hupuexercise.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.pz.hupuexercise.login.model.model.LoginInfo;
import com.example.pz.hupuexercise.login.model.model.LoginUserInfo;
import com.google.gson.Gson;

/**
 * Created by pz on 2016/8/21.
 */

public class PrefUtil {
    static Gson gson;

    static {
        if(gson == null) {
            gson = new Gson();
        }
    }

    public static void setLoginInfo(LoginInfo userInfo, Context context) {
        if(!userInfo.getResult().getToken().isEmpty()) {
            SharedPreferences.Editor prefsEditor = context.getSharedPreferences(Constant.LOGIN_INFO_FLAG, Context.MODE_PRIVATE).edit();
            String userInfoString = gson.toJson(userInfo);
            prefsEditor.putString(Constant.LOGIN_USER_INFO_FLAG, userInfoString);
            prefsEditor.commit();
        }
    }

    public static LoginInfo getLoginInfo(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(Constant.LOGIN_INFO_FLAG, Context.MODE_PRIVATE);
        String loginUserInfoString = prefs.getString(Constant.LOGIN_USER_INFO_FLAG, null);
        if(loginUserInfoString != null) {
            LoginInfo LoginInfo = gson.fromJson(loginUserInfoString, LoginInfo.class);
            return LoginInfo;
        }
        return null;
    }

    public static String getHuPuSign(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constant.HUPU_SIGN, "HUPU_SALT_AKJfoiwer394Jeiow4u309");
    }

    public static void setHuPuSign(Context context, String hupuSign) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString(Constant.HUPU_SIGN, hupuSign).apply();
    }

    public static int getIntValue(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt("isFirstOpen", 0);
    }

    public static void setIntValue(Context context, int value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putInt("isFirstOpen", value).apply();
    }
}
