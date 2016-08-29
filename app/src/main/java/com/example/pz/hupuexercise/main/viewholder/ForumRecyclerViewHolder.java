package com.example.pz.hupuexercise.main.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.pz.hupuexercise.R;
import com.facebook.drawee.view.DraweeView;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pz on 2016/8/28.
 */

public class ForumRecyclerViewHolder extends RecyclerView.ViewHolder {

    public SimpleDraweeView listForumDrawee;
    public TextView listTitleText;
    public TextView listUsernameText;
    public TextView listLightText;
    public TextView listCommentText;


    public ForumRecyclerViewHolder(View itemView) {
        super(itemView);
        listForumDrawee = (SimpleDraweeView)itemView.findViewById(R.id.image_list_forum);
        listTitleText = (TextView)itemView.findViewById(R.id.text_list_title);
        listUsernameText = (TextView)itemView.findViewById(R.id.text_list_username);
        listLightText = (TextView)itemView.findViewById(R.id.text_list_light);
        listCommentText = (TextView)itemView.findViewById(R.id.text_list_comment);
    }
}
