package com.example.pz.hupuexercise.main.activity;

import android.os.Bundle;

import com.example.pz.hupuexercise.R;
import com.example.pz.hupuexercise.base.BaseActivity;
import com.example.pz.hupuexercise.main.iView.IMainView;
import com.example.pz.hupuexercise.main.presenter.MainPresenter;

/**
 * Created by pz on 2016/8/25.
 */

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {
        presenter = new MainPresenter(this, this);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void saveCurrentState(Bundle bundle) {

    }

    @Override
    protected void pauseOperation() {

    }

    @Override
    protected void stopOperation() {

    }
}
