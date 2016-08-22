package com.example.pz.hupuexercise.login.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pz.hupuexercise.R;
import com.example.pz.hupuexercise.base.BaseFragment;
import com.example.pz.hupuexercise.login.activity.LoginActivity;
import com.example.pz.hupuexercise.login.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pz on 2016/8/18.
 */
public class LoginFragment extends BaseFragment implements View.OnClickListener{

    View view;

    @BindView(R.id.layout_username)
    TextInputLayout usernameLayout;

    @BindView(R.id.layout_password)
    TextInputLayout passwordLayout;

    @BindView(R.id.checkbox_auto_login)
    AppCompatCheckBox autoLoginCheckBox;

    @BindView(R.id.button_login)
    AppCompatButton loginButton;

    LoginPresenter presenter;

    private boolean isAutoLogin = true;

    public static LoginFragment instanceOf(LoginPresenter loginPresenter) {
        LoginFragment loginFragment = new LoginFragment();
        Bundle args = new Bundle();

        loginFragment.setArguments(args);
        return loginFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loginButton.setOnClickListener(this);
        presenter = ((LoginActivity)getActivity()).getPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
//                ProgressDialog dialog = ProgressDialog.show(this.getContext(), "sdf", "asdfgasdf", true, false);
                presenter.login(usernameLayout, passwordLayout);
//                dialog.dismiss();
                break;
        }
    }


}
