package com.example.pz.hupuexercise.main.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.pz.hupuexercise.R;
import com.example.pz.hupuexercise.base.BaseActivity;
import com.example.pz.hupuexercise.base.BaseFragment;
import com.example.pz.hupuexercise.main.fragment.ForumFragment;
import com.example.pz.hupuexercise.main.iView.IMainView;
import com.example.pz.hupuexercise.main.presenter.MainPresenter;

import butterknife.BindView;

import static android.R.attr.fragment;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by pz on 2016/8/25.
 */

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView, NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.home_actionbar)
    Toolbar toolbar;
    @BindView(R.id.home_navigation)
    NavigationView navigationView;
    @BindView(R.id.home_drawer)
    DrawerLayout drawerLayout;

    @BindView(R.id.layout_home_content)
    ViewPager pager;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {
        presenter = new MainPresenter(this, this);
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);
//        replaceFragment(R.id.menu_forum);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.click_to_login) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new ForumFragment();
            }

            @Override
            public int getCount() {
                return 1;
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawers();
//        int itemId = item.getItemId();
//        return replaceFragment(itemId);
        return true;
    }

    boolean replaceFragment(int itemId) {
        switch (itemId) {
            case R.id.menu_forum:
                ForumFragment fragment = new ForumFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout_home_content, fragment, "forum");
                transaction.commit();
                return true;
            default:
                Toast.makeText(this, "asdf", Toast.LENGTH_LONG).show();
                return true;
        }

    }

    @Override
    protected void saveCurrentState(Bundle bundle) {

    }

    @Override
    protected void pauseOperation() {

    }

    @Override
    protected void stopOperation() {

    }
}
