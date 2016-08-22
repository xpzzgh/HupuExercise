package com.example.pz.hupuexercise.login.loginHttp;

import com.example.pz.hupuexercise.login.model.model.LoginInfo;
import com.example.pz.hupuexercise.login.model.model.LoginUserInfo;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by pz on 2016/8/20.
 */

public interface LoginRetrofit {

    @FormUrlEncoded
    @POST("loginUsernameEmail")
    Observable<LoginInfo> postLogin(@FieldMap Map<String, String> params, @Query("client") String client);
}
