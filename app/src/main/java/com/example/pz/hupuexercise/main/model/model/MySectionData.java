package com.example.pz.hupuexercise.main.model.model;

import java.io.Serializable;

/**
 * Created by pz on 2016/8/25.
 * 我的版块数据model
 */

public class MySectionData implements Serializable {
    MySection data;

    public MySection getData() {
        return data;
    }

    public void setData(MySection data) {
        this.data = data;
    }
}
