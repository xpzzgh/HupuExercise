package com.example.pz.hupuexercise.utils;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pz on 2016/8/21.
 */

public class HttpUtil {

    /**
     * 获取请求的sign
     * @param mContext
     * @param map 拼装sign所需的字段
     * @return
     */
    public static String getRequestSign(Context mContext, Map<String, String> map) {
        ArrayList<Map.Entry<String, String>> list =
                new ArrayList<Map.Entry<String, String>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override public int compare(Map.Entry<String, String> lhs, Map.Entry<String, String> rhs) {
                return lhs.getKey().compareTo(rhs.getKey());
            }
        });
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i = i + 1) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            Map.Entry<String, String> map1 = list.get(i);
            builder.append(map1.getKey()).append("=").append(map1.getValue());
        }
        builder.append(PrefUtil.getHuPuSign(mContext));
        return Util.stringToMD5(builder.toString());
    }

    public static String getAndroidId(Context mContext) {
        return Settings.Secure.getString(mContext.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static String getDeviceId(Context mContext) {
        String deviceId;
        TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm.getDeviceId() == null) {
            deviceId = getAndroidId(mContext);
        } else {
            deviceId = tm.getDeviceId();
        }
        return deviceId;
    }

    /**
     * 拼装请求用户版块信息所需的sign
     * @param mContext
     * @return
     */
    public static Map<String, String> getHttpRequestMap(Context mContext) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("client", getDeviceId(mContext));
        map.put("night", "0");
        UserHelper helper = UserHelper.instanceOf(mContext);
        if (helper.isLogin()) {
            try {
                map.put("token", URLEncoder.encode(helper.getLoginInfo().getResult().getToken(), "UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
