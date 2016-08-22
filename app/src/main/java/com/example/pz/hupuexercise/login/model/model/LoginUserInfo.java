package com.example.pz.hupuexercise.login.model.model;

import java.io.Serializable;

/**
 * Created by pz on 2016/8/21.
 */

public class LoginUserInfo extends LoginInfo {
    LoginResult result;


    public LoginResult getResult() {
        return result;
    }

    public void setResult(LoginResult result) {
        this.result = result;
    }
}
