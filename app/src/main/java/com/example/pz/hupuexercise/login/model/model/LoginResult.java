package com.example.pz.hupuexercise.login.model.model;

import com.example.pz.hupuexercise.login.model.Entity.Bind;
import com.example.pz.hupuexercise.login.model.Entity.Follow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pz on 2016/8/21.
 */

public class LoginResult implements Serializable{

    int balance;
    List<Bind> bind;
    String header;
    int hupuDollor_balance;
    String nickname;
    String nickname_set_url;
    int show_bind;
    String token;
    String uid;
    String username;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Bind> getBind() {
        return bind;
    }

    public void setBind(List<Bind> bind) {
        this.bind = bind;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getHupuDollor_balance() {
        return hupuDollor_balance;
    }

    public void setHupuDollor_balance(int hupuDollor_balance) {
        this.hupuDollor_balance = hupuDollor_balance;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname_set_url() {
        return nickname_set_url;
    }

    public void setNickname_set_url(String nickname_set_url) {
        this.nickname_set_url = nickname_set_url;
    }

    public int getShow_bind() {
        return show_bind;
    }

    public void setShow_bind(int show_bind) {
        this.show_bind = show_bind;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
