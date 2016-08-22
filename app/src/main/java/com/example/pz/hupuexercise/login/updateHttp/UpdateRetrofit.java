package com.example.pz.hupuexercise.login.updateHttp;

import com.example.pz.hupuexercise.login.model.model.UpdateSign;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by pz on 2016/8/21.
 */

public interface UpdateRetrofit {

    @GET("update.json")
    Observable<UpdateSign> getUpdateSign();

}
