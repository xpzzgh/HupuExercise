package com.example.pz.hupuexercise.login.model.model;

import com.example.pz.hupuexercise.login.model.Entity.Error;

import java.io.Serializable;

/**
 * Created by pz on 2016/8/21.
 */

public class LoginErrorInfo extends LoginInfo {
    Error error;

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
