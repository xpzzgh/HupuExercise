package com.example.pz.hupuexercise.base;

import android.support.v4.app.Fragment;


import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by pz on 2016/8/18.
 */
public class BaseFragment extends Fragment {


    public Unbinder unbinder;

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(unbinder != null) {
            unbinder.unbind();
        }
    }
}
