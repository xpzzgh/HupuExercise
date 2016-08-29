package com.example.pz.hupuexercise.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by pz on 2016/8/18.
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment {


    public Unbinder unbinder;

    public T fragmentPresenter;

    public View view;

    /**
     * 初始化presenter
     */
    public abstract void initPresenter();

    /**
     * ButterKnife绑定及其他初始化操作
     */
    public abstract void init();


    public T getPresenter() {
        return fragmentPresenter;
    }

    @Override
    public void onDestroy() {
        if(fragmentPresenter != null) {
            fragmentPresenter.destroy();
        }
        if(unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }
}
