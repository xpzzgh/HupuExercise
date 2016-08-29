package com.example.pz.hupuexercise.main.iView;

import com.example.pz.hupuexercise.base.IView;
import com.example.pz.hupuexercise.main.model.entity.GeneralPost;

import java.util.List;

/**
 * Created by pz on 2016/8/28.
 */

public interface IForumView extends IView {

    void showProgress();
    void hideProgress();
    void fillDatas(List<GeneralPost> datas);
}
