package com.example.pz.hupuexercise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.pz.hupuexercise.MainActivity;
import com.example.pz.hupuexercise.R;
import com.example.pz.hupuexercise.base.BaseActivity;
import com.example.pz.hupuexercise.base.MyApplication;
import com.example.pz.hupuexercise.login.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

/**
 * Created by pz on 2016/8/22.
 */

public class ErrorActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_error);
        ButterKnife.bind(this);
        final Intent intent = new Intent(this, LoginActivity.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomActivityOnCrash.restartApplicationWithIntent(ErrorActivity.this, intent, null);
            }
        });
    }
}
