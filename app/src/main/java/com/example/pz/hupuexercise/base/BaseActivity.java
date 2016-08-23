package com.example.pz.hupuexercise.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.pz.hupuexercise.utils.MyLog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by pz on 2016/8/18.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity{

    public T presenter;
    public Unbinder unbinder;
    public ActivityManager activityManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityManager = ActivityManager.instanceOf();  //初始化ActivityManager对象
        activityManager.add(this); //默认将继承baseActivity的activity压入堆栈
        setContentView(getLayoutResId());
        //setImmerseBar();
        unbinder = ButterKnife.bind(this); //初始化butterknife
        initPresenter();
        initView();
        MyLog.v(MyLog.BASE_TAG, this.getLocalClassName() + ": OnCreate");
    }

    /**
     * 设置app页面顶端沉浸
     */
    protected void setImmerseBar() {
        if(Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int opinion = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(opinion);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
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
            unbinder.unbind();  //butterKnife 解绑
        }
        presenter.destroy(); //释放presenter资源
        MyLog.v(MyLog.BASE_TAG, this.getLocalClassName() + ": OnDestroy");
        activityManager.finishActivity(this); //将要destroy的activity移出堆栈
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
