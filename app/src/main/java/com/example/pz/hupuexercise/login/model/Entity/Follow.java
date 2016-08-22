package com.example.pz.hupuexercise.login.model.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pz on 2016/8/21.
 */

public class Follow implements Serializable{

    List<Integer> lids;
    List<List<Integer>> tids;

    public List<Integer> getLids() {
        return lids;
    }

    public void setLids(List<Integer> lids) {
        this.lids = lids;
    }

    public List<List<Integer>> getTids() {
        return tids;
    }

    public void setTids(List<List<Integer>> tids) {
        this.tids = tids;
    }
}
