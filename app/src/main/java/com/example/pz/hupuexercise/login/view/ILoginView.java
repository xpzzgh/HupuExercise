package com.example.pz.hupuexercise.login.view;

import android.app.ProgressDialog;

import com.example.pz.hupuexercise.base.IView;

/**
 * Created by pz on 2016/8/18.
 */
public interface ILoginView extends IView{

    void showLoginSuccess();

    void showLoginError(String errorString);

    void showLoadDialog(String title, String content);

    void hideLoadDialog();
}
