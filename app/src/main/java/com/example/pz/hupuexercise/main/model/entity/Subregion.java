package com.example.pz.hupuexercise.main.model.entity;

import java.io.Serializable;

/**
 * Created by pz on 2016/8/24.
 */

/**
 * 子分区entity
 */
public class Subregion implements Serializable {
    String backImg;
    int count;
    String description;
    int fid;
    String forumtag;
    String logo;
    String name;
    int user_password;
    int vieworder;

    public String toString() {
        return name;
    }

    public String getBackImg() {
        return backImg;
    }

    public void setBackImg(String backImg) {
        this.backImg = backImg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getForumtag() {
        return forumtag;
    }

    public void setForumtag(String forumtag) {
        this.forumtag = forumtag;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_password() {
        return user_password;
    }

    public void setUser_password(int user_password) {
        this.user_password = user_password;
    }

    public int getVieworder() {
        return vieworder;
    }

    public void setVieworder(int vieworder) {
        this.vieworder = vieworder;
    }
}
