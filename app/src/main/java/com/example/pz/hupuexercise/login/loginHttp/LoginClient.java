package com.example.pz.hupuexercise.login.loginHttp;

/**
 * Created by pz on 2016/8/20.
 */

public class LoginClient {
    private LoginClient(){}

    private static class LoginClientHolder{
        public static final LoginRetrofit retrofit = LoginClientGenerator.getRetrofit();
    }

    public static LoginRetrofit instanceOf() {
        return LoginClientHolder.retrofit;
    }
}
