package com.example.pz.hupuexercise.main.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 引用
 * Created by pz on 2016/8/28.
 */

public class Quote implements Serializable {
    String content;
    List<String> header;
    String toggleContent;

    public String toString() {
        return content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public String getToggleContent() {
        return toggleContent;
    }

    public void setToggleContent(String toggleContent) {
        this.toggleContent = toggleContent;
    }
}
