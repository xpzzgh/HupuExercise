package com.example.pz.hupuexercise.login.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.Preference;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewOverlay;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pz.hupuexercise.R;
import com.example.pz.hupuexercise.base.BaseActivity;
import com.example.pz.hupuexercise.login.adapter.LoginPagerAdapter;
import com.example.pz.hupuexercise.login.fragment.LoginFragment;
import com.example.pz.hupuexercise.login.presenter.LoginPresenter;
import com.example.pz.hupuexercise.login.view.ILoginView;
import com.example.pz.hupuexercise.utils.Constant;
import com.example.pz.hupuexercise.utils.MyLog;
import com.example.pz.hupuexercise.utils.PrefUtil;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by pz on 2016/8/18.
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView{

    @BindView(R.id.tabLayout_login)
    TabLayout loginTab;

    @BindView(R.id.viewpager_login)
    ViewPager loginPager;

    SharedPreferences sp;
    LoginPagerAdapter adapter;

    ProgressDialog loginDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        sp = getSharedPreferences(Constant.LOGIN_INFO_FLAG, Context.MODE_PRIVATE);
        adapter = new LoginPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(LoginFragment.instanceOf(presenter), Constant.LoginString);
        adapter.addFragment(LoginFragment.instanceOf(presenter), Constant.LoginString);
        loginPager.setAdapter(adapter);
        loginTab.setupWithViewPager(loginPager);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initPresenter() {
        presenter = new LoginPresenter(this, this);
    }

    @Override
    public void showLoginSuccess() {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginError(String errorString) {
        Snackbar snackbar = Snackbar.make(loginTab, errorString, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        TextView textView = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.cardview_light_background));
        snackbar.show();
    }

    @Override
    public void hideLoadDialog() {
        if(loginDialog != null && loginDialog.isShowing()) {
            loginDialog.dismiss();
        }
    }

    @Override
    public void showLoadDialog(String title, String content) {
        if(loginDialog == null) {
            loginDialog = new ProgressDialog(this);
            loginDialog.setIndeterminate(true);
            loginDialog.setCancelable(false);
        }
        loginDialog.setMessage(content);
        loginDialog.setTitle(title);
        if(!loginDialog.isShowing()) {
            loginDialog.show();
        }
    }

    @Override
    protected void saveCurrentState(Bundle bundle) {
        MyLog.v(MyLog.LOGIN_TAG, "Save Login State");
    }

    @Override
    protected void pauseOperation() {
        MyLog.v(MyLog.LOGIN_TAG, "Pause Login");
    }

    @Override
    protected void stopOperation() {
        MyLog.v(MyLog.LOGIN_TAG, "Stop Login");

    }
}
