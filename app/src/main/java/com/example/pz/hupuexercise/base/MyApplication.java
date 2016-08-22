package com.example.pz.hupuexercise.base;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

/**
 * Created by pz on 2016/8/18.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化fresco
        Fresco.initialize(this);
        //报错时跳出错误处理页面
        CustomActivityOnCrash.setLaunchErrorActivityWhenInBackground(true);  //错误处理，设为false表示不显示，同时系统错误也将被屏蔽
        CustomActivityOnCrash.setShowErrorDetails(true); //是否显示报错详情和按钮
        CustomActivityOnCrash.setEnableAppRestart(true); //重启还是关闭app  true为重启
        CustomActivityOnCrash.install(this);
    }
}
