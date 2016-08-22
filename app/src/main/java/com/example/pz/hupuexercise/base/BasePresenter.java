package com.example.pz.hupuexercise.base;

import android.content.Context;

import java.io.Serializable;

import rx.Subscription;

/**
 * Created by pz on 2016/8/18.
 */
public abstract class BasePresenter<T extends IView>{

    protected T iView;
    protected Context context;
    protected Subscription subscription;

    public BasePresenter(Context context, T iView) {
        this.iView = iView;
        this.context = context;
    }

    public abstract void destroy();
}
