package com.example.pz.hupuexercise.main.model.entity;

import java.io.Serializable;

/**
 *
 * 帖子评论 model
 * Created by pz on 2016/8/28.
 */

public class Comment implements Serializable {

    String content;
    long create_time;
    int floor;
    int light_count;
    int pid;
    long puid;
    Quote quote;
    int quote_deleted;
    String smallcontent;
    String time;
    String toggleContent;
    String update_info;
    int user_banned;
    String userImg;
    String userName;
    int via;

    public String toString() {
        return content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getLight_count() {
        return light_count;
    }

    public void setLight_count(int light_count) {
        this.light_count = light_count;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public long getPuid() {
        return puid;
    }

    public void setPuid(long puid) {
        this.puid = puid;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public int getQuote_deleted() {
        return quote_deleted;
    }

    public void setQuote_deleted(int quote_deleted) {
        this.quote_deleted = quote_deleted;
    }

    public String getSmallcontent() {
        return smallcontent;
    }

    public void setSmallcontent(String smallcontent) {
        this.smallcontent = smallcontent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getToggleContent() {
        return toggleContent;
    }

    public void setToggleContent(String toggleContent) {
        this.toggleContent = toggleContent;
    }

    public String getUpdate_info() {
        return update_info;
    }

    public void setUpdate_info(String update_info) {
        this.update_info = update_info;
    }

    public int getUser_banned() {
        return user_banned;
    }

    public void setUser_banned(int user_banned) {
        this.user_banned = user_banned;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getVia() {
        return via;
    }

    public void setVia(int via) {
        this.via = via;
    }
}
