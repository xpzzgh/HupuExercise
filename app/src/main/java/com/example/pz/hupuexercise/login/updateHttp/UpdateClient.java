package com.example.pz.hupuexercise.login.updateHttp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pz on 2016/8/21.
 */

public class UpdateClient {

    private static Retrofit retrofit;
    private static UpdateRetrofit updateRetrofit;

    private UpdateClient() {}

    static {
        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.pursll.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public static UpdateRetrofit instanceOf() {
        if(updateRetrofit == null) {
            updateRetrofit = retrofit.create(UpdateRetrofit.class);
        }
        return updateRetrofit;
    }
}
