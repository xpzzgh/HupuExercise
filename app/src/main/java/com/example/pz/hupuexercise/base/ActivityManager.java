package com.example.pz.hupuexercise.base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by pz on 2016/8/22.
 */

public class ActivityManager {

    private static ActivityManager manager;
    private static Stack<Activity> activityStack = new Stack<Activity>();

    private ActivityManager() {}

    public static ActivityManager instanceOf() {
        if(manager == null) {
            manager = new ActivityManager();
        }
        return manager;
    }

    /**
     * 将actiivty插入堆栈
     * @param activity
     */
    public void add(Activity activity) {
        activityStack.add(activity);
    }

    /**
     * 将指定activity从堆栈中移除，并finish该activity
     * @param activity
     */
    public void finishActivity(Activity activity) {
        if(activity != null) {
            activityStack.remove(activity);
            if(!activity.isFinishing()) {
                activity.finish();
            }
            activity = null;
        }
    }

    /**
     * 获取当前activity
     * @return 当前所在的 activity
     */
    public Activity getCurrentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 移除所有的activity，并finish掉
     * @return 删除的activity的数量
     */
    public int finishAll() {
        Activity activity;
        int finishNumber = 0;
        for (int i = 0; i<activityStack.size(); i++) {
            finishNumber++;
            activity = activityStack.get(i);
            finishActivity(activity);
        }
        return finishNumber;
    }

    /**
     * finish当前的activity
     * 注意：切换时要关闭前一个Activity时不要用这个方法
     */
    public void finishCurrentActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * finish所有类名为cls的Activity
     * @param cls
     * @return 一共finish掉且类名为cls的Activity的数量
     */
    public int finishClassActivity(Class<?> cls) {
        List<Activity> activities = new ArrayList<Activity>();
        for(Activity activity : activityStack) {
            if(activity.getClass().equals(cls)) {
                activities.add(activity);
            }
        }
        int i = activities.size();
        for(Activity activity : activities) {
            finishActivity(activity);
        }
        return i;
    }

    /**
     * finish掉所有在类名为cls的activity后面插入的activity
     * @param cls 所需显示的activity的类名
     * @return finish掉的activity的数量
     */
    public int finishExceptClassAvtivity(Class<?> cls) {
        int i = 0;
        while (true) {
            Activity activity = getCurrentActivity();
            if(activity == null) {
                break;
            }
            if(activity.getClass().equals(cls)) {
                break;
            }
            i++;
            finishActivity(activity);
        }
        return i;
    }


}



































