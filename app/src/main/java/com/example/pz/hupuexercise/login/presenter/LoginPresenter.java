package com.example.pz.hupuexercise.login.presenter;

import android.content.Context;
import android.support.annotation.IntegerRes;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;

import com.example.pz.hupuexercise.base.BasePresenter;
import com.example.pz.hupuexercise.login.loginHttp.LoginClient;
import com.example.pz.hupuexercise.login.model.model.LoginErrorInfo;
import com.example.pz.hupuexercise.login.model.model.LoginInfo;
import com.example.pz.hupuexercise.login.model.model.LoginUserInfo;
import com.example.pz.hupuexercise.login.model.model.UpdateSign;
import com.example.pz.hupuexercise.login.updateHttp.UpdateClient;
import com.example.pz.hupuexercise.login.view.ILoginView;
import com.example.pz.hupuexercise.utils.Constant;
import com.example.pz.hupuexercise.utils.HttpUtil;
import com.example.pz.hupuexercise.utils.MyLog;
import com.example.pz.hupuexercise.utils.PrefUtil;
import com.example.pz.hupuexercise.utils.Util;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by pz on 2016/8/18.
 */
public class LoginPresenter extends BasePresenter<ILoginView>{



    public LoginPresenter(Context context, ILoginView iView) {
        super(context, iView);
    }

    /**
     * 执行登陆的逻辑操作
     * @param usernameLayout 用户名的layout
     * @param passwordLayout 密码的layout
     */
    public void login(TextInputLayout usernameLayout, TextInputLayout passwordLayout) {
        final String userText;
        final String passwordText;
        final String passwordMd5;

        if(usernameLayout != null && passwordLayout != null) {
            userText = usernameLayout.getEditText().getText().toString();
            passwordText = passwordLayout.getEditText().getText().toString();
            if(userText.isEmpty()) {
                passwordLayout.setError(null);
                passwordLayout.setErrorEnabled(false);
                usernameLayout.setError("用户名不能为空");
            }else if(passwordText.isEmpty()) {
                usernameLayout.setErrorEnabled(false);
                usernameLayout.setError(null);
//                passwordLayout.setErrorEnabled(true);
                passwordLayout.setError("密码不能为空");
            }else {
                usernameLayout.setError(null);
                usernameLayout.setErrorEnabled(false);
                passwordLayout.setError(null);
                passwordLayout.setErrorEnabled(false);
                passwordMd5 = Util.stringToMD5(passwordText);

                subscription = UpdateClient.instanceOf().getUpdateSign()
                        .subscribeOn(Schedulers.io())
                        .timeout(5, TimeUnit.SECONDS)
                        .flatMap(new Func1<UpdateSign, Observable<? extends LoginInfo>>() {
                            @Override
                            public Observable<? extends LoginInfo> call(UpdateSign updateSign) {
                                MyLog.v(MyLog.LOGIN_TAG, "updateSign 获取成功，flatmap");
                                if(updateSign == null) {
                                    return null;
                                }
                                String hupuSign = updateSign.getHupuSign();
                                MyLog.v(MyLog.LOGIN_TAG, "hupu salt : " + hupuSign);
                                if(!hupuSign.isEmpty()) {

                                    PrefUtil.setHuPuSign(context, hupuSign);
                                }
                                HashMap<String, String> params = new HashMap<String, String>();
                                params.put("client", HttpUtil.getDeviceId(context));
                                params.put("username", userText);
                                params.put("password", passwordMd5);
                                String sign = HttpUtil.getRequestSign(context, params);
                                params.put("sign", sign);

                                return LoginClient.instanceOf().postLogin(params, HttpUtil.getDeviceId(context));
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<LoginInfo>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                MyLog.e(MyLog.LOGIN_TAG, e.toString());
                                iView.showLoginError("网络错误，请检查网络后重试");
                            }

                            @Override
                            public void onNext(LoginInfo loginInfo) {
                                MyLog.v(MyLog.LOGIN_TAG, "userinfo获取成功，onNext");
                                if(loginInfo.getIs_login() == 1) {
                                    PrefUtil.setLoginInfo(loginInfo, context);
                                    iView.showLoginSuccess();
                                }else {
                                    iView.showLoginError(loginInfo.getError().getText());
                                }
                                iView.hideLoadDialog();
                            }

                            @Override
                            public void onStart() {
                                super.onStart();
                                iView.showLoadDialog("登录", "正在登录中，请稍等！");
                            }
                        });
            }
        }
    }

    @Override
    public void destroy() {
        if(subscription != null) {
            subscription.unsubscribe();
        }
    }
}
