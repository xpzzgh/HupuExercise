package com.example.pz.hupuexercise.login.model.Entity;

import java.io.Serializable;

/**
 * Created by pz on 2016/8/21.
 */

public class Error implements Serializable{

    int id;
    String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
