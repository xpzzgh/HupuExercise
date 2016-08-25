package com.example.pz.hupuexercise.main.model.model;

import com.example.pz.hupuexercise.main.model.entity.Subregion;

import java.io.Serializable;
import java.util.List;

/**
 * Created by pz on 2016/8/25.
 */

public class Section implements Serializable {
    List<Subregion> data;
    String name;
    int weight;

    public List<Subregion> getData() {
        return data;
    }

    public void setData(List<Subregion> data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
