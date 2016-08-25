package com.example.pz.hupuexercise.main.model.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by pz on 2016/8/25.
 */

public class Sections implements Serializable {
    int fld;
    String name;
    List<Section> sub;

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

    public List<Section> getSub() {
        return sub;
    }

    public void setSub(List<Section> sub) {
        this.sub = sub;
    }
}
