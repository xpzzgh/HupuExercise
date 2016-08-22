package com.example.pz.hupuexercise.utils;

import android.util.Log;

/**
 * Created by pz on 2016/8/18.
 */
public class MyLog {

    private static int currentLevel = 8;
    private static final int VERBOSE_LEVEL = 7;
    private static final int DEBUG_LEVEL = 6;
    private static final int INFO_LEVEL = 5;
    private static final int WARN_LEVEL = 4;
    private static final int ERROR_LEVEL = 3;

    public static final String LOGIN_TAG = "login_tag";
    public static final String BASE_TAG = "base_tag";


    public static void v(String tag, String msg) {
        if(currentLevel > VERBOSE_LEVEL) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if(currentLevel > DEBUG_LEVEL) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if(currentLevel > INFO_LEVEL) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if(currentLevel > WARN_LEVEL) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if(currentLevel > ERROR_LEVEL) {
            Log.e(tag, msg);
        }
    }
}
