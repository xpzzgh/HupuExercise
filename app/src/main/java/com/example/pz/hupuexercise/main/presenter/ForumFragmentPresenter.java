package com.example.pz.hupuexercise.main.presenter;

import android.app.Activity;
import android.content.Context;

import com.example.pz.hupuexercise.base.BasePresenter;
import com.example.pz.hupuexercise.main.iView.IForumView;
import com.example.pz.hupuexercise.main.model.entity.GeneralPost;
import com.example.pz.hupuexercise.utils.HttpUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rx.Observable;

import static com.example.pz.hupuexercise.utils.HttpUtil.getHttpRequestMap;

/**
 * Created by pz on 2016/8/28.
 */

public class ForumFragmentPresenter extends BasePresenter<IForumView> {

    public ForumFragmentPresenter(Context context, IForumView iView) {
        super(context, iView);
    }

    public void fetchDataList(int page) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000);
                }catch (InterruptedException e) {}
                ((Activity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iView.fillDatas(getData());
                        iView.hideProgress();
                    }
                });
            }
        }).start();

        Map<String, String> requestParams =  HttpUtil.getHttpRequestMap(context);
        String sign = HttpUtil.getRequestSign(context, requestParams);

    }

    List<GeneralPost> getData() {
        List<GeneralPost> data = new ArrayList<GeneralPost>();
        GeneralPost post = new GeneralPost();
        post.setForum_logo("https://i3.hoopchina.com.cn//blogfile/201510/12/BbsImg144462016469330_110*88.png");
        post.setLightReply(7);
        post.setReplies(1009);
        post.setTitle("测试一下卡片模块是不是能够正常工作，如果能够正常工作，那就没什么事情了！！！！");
        post.setUserName("123lovea");
        data.add(post);
        data.add(post);
        data.add(post);
        data.add(post);
        data.add(post);
        data.add(post);
        data.add(post);
        data.add(post);
        data.add(post);
        data.add(post);
        return data;
    }

    @Override
    public void destroy() {
        if(subscription != null) {
            subscription.unsubscribe();
        }
    }
}