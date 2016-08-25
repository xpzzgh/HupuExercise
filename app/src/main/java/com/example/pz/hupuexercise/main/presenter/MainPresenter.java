package com.example.pz.hupuexercise.main.presenter;

import android.content.Context;

import com.example.pz.hupuexercise.base.BasePresenter;
import com.example.pz.hupuexercise.main.iView.IMainView;

/**
 * Created by pz on 2016/8/25.
 */

public class MainPresenter extends BasePresenter<IMainView> {

    public MainPresenter(Context context, IMainView iView) {
        super(context, iView);
    }

    @Override
    public void destroy() {

    }
}
