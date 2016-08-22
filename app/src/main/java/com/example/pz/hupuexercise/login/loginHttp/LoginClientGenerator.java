package com.example.pz.hupuexercise.login.loginHttp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pz on 2016/8/20.
 */

public class LoginClientGenerator {

    public static Retrofit retrofit;

    private LoginClientGenerator(){}
    static {
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://games.mobileapi.hupu.com/1/7.0.8/user/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public static LoginRetrofit getRetrofit() {
        LoginRetrofit loginRetrofit = retrofit.create(LoginRetrofit.class);
        return loginRetrofit;
    }
}
