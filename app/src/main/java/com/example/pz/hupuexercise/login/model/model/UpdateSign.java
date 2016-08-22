package com.example.pz.hupuexercise.login.model.model;

import com.example.pz.hupuexercise.login.model.Entity.Extra;

/**
 * Created by pz on 2016/8/21.
 */

public class UpdateSign {
    Extra extra;
    String hupuSign;
    String updateInfo;
    String updateUrl;
    String versionCode;

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public String getHupuSign() {
        return hupuSign;
    }

    public void setHupuSign(String hupuSign) {
        this.hupuSign = hupuSign;
    }

    public String getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(String updateInfo) {
        this.updateInfo = updateInfo;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }
}
