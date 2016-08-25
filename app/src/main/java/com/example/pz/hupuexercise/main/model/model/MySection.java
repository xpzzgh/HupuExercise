package com.example.pz.hupuexercise.main.model.model;

import com.example.pz.hupuexercise.main.model.entity.Subregion;

import java.io.Serializable;
import java.util.List;

/**
 * Created by pz on 2016/8/24.
 * 我的版块data类
 */

public class MySection implements Serializable {
    int fld;
    String name;
    List<Subregion> sub;

    public String toString() {
        return name;
    }

    public int getFld() {
        return fld;
    }

    public void setFld(int fld) {
        this.fld = fld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subregion> getSub() {
        return sub;
    }

    public void setSub(List<Subregion> sub) {
        this.sub = sub;
    }
}
