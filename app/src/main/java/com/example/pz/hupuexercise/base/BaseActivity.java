package com.example.pz.hupuexercise.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.pz.hupuexercise.utils.MyLog;

import java.io.Serializable;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by pz on 2016/8/18.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity{

    public T presenter;
    public Unbinder unbinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        unbinder = ButterKnife.bind(this); //初始化butterknife
        initPresenter();
        initView();
        MyLog.v(MyLog.BASE_TAG, this.getLocalClassName() + ": OnCreate");
    }

    public T getPresenter() {
        return presenter;
    }

    protected abstract int getLayoutResId();

    protected abstract void initPresenter();

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        if(unbinder != null) {
            unbinder.unbind();
        }
        presenter.destroy();
        MyLog.v(MyLog.BASE_TAG, this.getLocalClassName() + ": OnDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        pauseOperation();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopOperation();
        MyLog.v(MyLog.BASE_TAG, this.getLocalClassName() + ": OnStop");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        saveCurrentState(outState);
        super.onSaveInstanceState(outState);
    }
    //保存临时数据，进度等信息
    protected abstract void saveCurrentState(Bundle bundle);

    //停止动画、提交永久性保存、释放系统资源
    protected abstract void pauseOperation();

    //释放泄露内存、占用cpu和时长较长的操作
    protected abstract void stopOperation();
}
