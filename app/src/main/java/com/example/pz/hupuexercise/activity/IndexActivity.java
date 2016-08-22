package com.example.pz.hupuexercise.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.pz.hupuexercise.R;
import com.example.pz.hupuexercise.login.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pz on 2016/8/22.
 */

public class IndexActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e) {}
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(IndexActivity.this, LoginActivity.class);
                        startActivity(intent);
                        //fade_in 表示下一个activity淡入，fade_out表示这个activity切换时淡出
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        IndexActivity.this.finish();
                    }
                });
            }
        }).start();


    }
}
