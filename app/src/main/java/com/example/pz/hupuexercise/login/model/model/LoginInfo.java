package com.example.pz.hupuexercise.login.model.model;

import com.example.pz.hupuexercise.login.model.Entity.Error;

import java.io.Serializable;

/**
 * Created by pz on 2016/8/21.
 */

public class LoginInfo implements Serializable {
    int is_login;
    Error error;
    LoginResult result;

    public int getIs_login() {
        return is_login;
    }

    public void setIs_login(int is_login) {
        this.is_login = is_login;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public LoginResult getResult() {
        return result;
    }

    public void setResult(LoginResult result) {
        this.result = result;
    }
}
