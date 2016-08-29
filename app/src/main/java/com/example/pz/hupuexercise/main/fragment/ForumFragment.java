package com.example.pz.hupuexercise.main.fragment;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.pz.hupuexercise.R;
import com.example.pz.hupuexercise.base.BaseFragment;
import com.example.pz.hupuexercise.base.IView;
import com.example.pz.hupuexercise.main.activity.MainActivity;
import com.example.pz.hupuexercise.main.adapter.ForumRecyclerViewAdapter;
import com.example.pz.hupuexercise.main.iView.IForumView;
import com.example.pz.hupuexercise.main.model.entity.GeneralPost;
import com.example.pz.hupuexercise.main.presenter.ForumFragmentPresenter;
import com.example.pz.hupuexercise.main.presenter.MainPresenter;
import com.example.pz.hupuexercise.utils.Constant;
import com.example.pz.hupuexercise.widget.ForumRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by pz on 2016/8/26.
 */

public class ForumFragment extends BaseFragment<ForumFragmentPresenter> implements IForumView,
        View.OnClickListener, ForumRecyclerView.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{

    View view;
    @BindViews({R.id.layout_forum_NBA,R.id.layout_forum_CBA, R.id.layout_forum_equipment, R.id.layout_forum_jrs, R.id.layout_forum_mine})
    List<LinearLayout> forumLayouts;

//    @BindViews({R.id.image_forum_NBA, R.id.image_forum_CBA, R.id.image_forum_equipment, R.id.image_forum_jrs, R.id.image_forum_mine})
//    List<ImageView> forumIcons;
//
    @BindViews({R.id.text_forum_NBA, R.id.text_forum_CBA, R.id.text_forum_equipment, R.id.text_forum_jrs, R.id.text_forum_mine})
    List<TextView> forumTitles;

    @BindView(R.id.image_forum_NBA)
    ImageView NBAForumIcon;
    @BindView(R.id.image_forum_CBA)
    ImageView CBAForumIcon;
    @BindView(R.id.image_forum_equipment)
    ImageView equipmentForumIcon;
    @BindView(R.id.image_forum_jrs)
    ImageView jrsForumIcon;
    @BindView(R.id.image_forum_mine)
    ImageView mineForumIcon;

    @BindView(R.id.text_forum_NBA)
    TextView NBAForumTitle;
    @BindView(R.id.text_forum_CBA)
    TextView CBAForumTitle;
    @BindView(R.id.text_forum_equipment)
    TextView equipmentForumTitle;
    @BindView(R.id.text_forum_jrs)
    TextView jrsForumTitle;
    @BindView(R.id.text_forum_mine)
    TextView mineForumTitle;

    @BindView(R.id.recycler_forum_list)
    ForumRecyclerView recyclerView;

    @BindView(R.id.refresh_forum)
    SwipeRefreshLayout refreshLayout;

    /**
     * 上一次选中的子版块的索引（index）
     */
    int lastSelectedIndex;

    List<GeneralPost> datas;

    ForumRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_forum, container, false);
        init();
        initPresenter();
        return view;
    }


    @Override
    public void init() {
        unbinder = ButterKnife.bind(this, view);
        datas = new ArrayList<GeneralPost>();
        selectTab(Constant.NBA_FORUM_INDEX);
        for(LinearLayout layout:forumLayouts) {
            layout.setOnClickListener(this);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ForumRecyclerViewAdapter(getActivity(), datas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLoadMoreListener(this);
        refreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void initPresenter() {
        fragmentPresenter = new ForumFragmentPresenter(getActivity(), this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_forum_NBA:
                selectTab(Constant.NBA_FORUM_INDEX);
                break;
            case R.id.layout_forum_CBA:
                selectTab(Constant.CBA_FORUM_INDEX);
                break;
            case R.id.layout_forum_equipment:
                selectTab(Constant.EQUIPMENT_FORUM_INDEX);
                break;
            case R.id.layout_forum_jrs:
                selectTab(Constant.JRS_FORUM_INDEX);
                break;
            case R.id.layout_forum_mine:
                selectTab(Constant.MINE_FORUM_INDEX);
                break;
            default:
                break;
        }
    }

    @Override
    public void hideProgress() {
        if(refreshLayout != null && refreshLayout.isRefreshing()) {
            refreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showProgress() {
        if(refreshLayout != null && !refreshLayout.isRefreshing()) {
            refreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void loadMore() {
        showProgress();
        fragmentPresenter.fetchDataList(1);
    }

    @Override
    public void onRefresh() {
        if(!refreshLayout.isRefreshing()) {
            refreshLayout.setRefreshing(true);
        }
        fragmentPresenter.fetchDataList(1);
    }

    @Override
    public void fillDatas(List<GeneralPost> datas) {
        this.datas.addAll(datas);
        adapter.notifyDataSetChanged();
    }

    /**
     * 清除底部 子版块的选中状态
     */
    void clearLayoutState() {
        NBAForumIcon.setImageResource(R.mipmap.icon_forum_nba);
        CBAForumIcon.setImageResource(R.mipmap.icon_forum_cba);
        equipmentForumIcon.setImageResource(R.mipmap.icon_forum_equipment);
        jrsForumIcon.setImageResource(R.mipmap.icon_forum_jrs);
        mineForumIcon.setImageResource(R.mipmap.icon_forum_mine);
        for(TextView tv:forumTitles) {
            tv.setTextColor(getResources().getColor(R.color.colorNotChecked));
        }
//        NBAForumTitle.setTextColor(getResources().getColor(R.color.colorNotChecked));
    }

    /**
     * 设置论坛各个子版块选中状态
     * @param index 子版块的索引号
     */
    void selectTab(int index) {
        if (index != lastSelectedIndex) {
            clearLayoutState();
            lastSelectedIndex = index;
            switch (index) {
                case Constant.NBA_FORUM_INDEX:
                    setCheckedState(NBAForumIcon, NBAForumTitle, R.mipmap.icon_forum_nba_checked, R.color.colorChecked);
                    break;
                case Constant.CBA_FORUM_INDEX:
                    setCheckedState(CBAForumIcon, CBAForumTitle, R.mipmap.icon_forum_cba_checked, R.color.colorChecked);
                    break;
                case Constant.EQUIPMENT_FORUM_INDEX:
                    setCheckedState(equipmentForumIcon, equipmentForumTitle, R.mipmap.icon_forum_equipment_checked, R.color.colorChecked);
                    break;
                case Constant.JRS_FORUM_INDEX:
                    setCheckedState(jrsForumIcon, jrsForumTitle, R.mipmap.icon_forum_jrs_checked, R.color.colorChecked);
                    break;
                case Constant.MINE_FORUM_INDEX:
                    setCheckedState(mineForumIcon, mineForumTitle, R.mipmap.icon_forum_mine_checked, R.color.colorChecked);
                    break;
                default:
                    break;
            }
        }
    }

    void setCheckedState(ImageView imageView, TextView textView, int resId, int color) {
        imageView.setImageResource(resId);
        textView.setTextColor(getResources().getColor(color));
    }
}
