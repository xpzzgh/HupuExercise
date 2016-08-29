package com.example.pz.hupuexercise.main.model.entity;

import java.io.Serializable;

/**
 * 帖子概述
 * Created by pz on 2016/8/28.
 */

public class GeneralPost implements Serializable {

    int fid;
    String forum_logo;   //logo url
    String forum_name;  //论坛名字
    String imgs;
    int lightReply;  //点亮数目
    long puid;
    int replies;   //评论数目
    long tid;
    String time;   //时间
    String title;   //帖子标题
    String userName;  //楼主

    public String toString() {
        return title;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getForum_logo() {
        return forum_logo;
    }

    public void setForum_logo(String forum_logo) {
        this.forum_logo = forum_logo;
    }

    public String getForum_name() {
        return forum_name;
    }

    public void setForum_name(String forum_name) {
        this.forum_name = forum_name;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public int getLightReply() {
        return lightReply;
    }

    public void setLightReply(int lightReply) {
        this.lightReply = lightReply;
    }

    public long getPuid() {
        return puid;
    }

    public void setPuid(long puid) {
        this.puid = puid;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
