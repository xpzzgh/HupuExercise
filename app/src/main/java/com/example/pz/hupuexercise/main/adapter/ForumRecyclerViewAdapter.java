package com.example.pz.hupuexercise.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pz.hupuexercise.R;
import com.example.pz.hupuexercise.main.model.entity.GeneralPost;
import com.example.pz.hupuexercise.main.viewholder.ForumRecyclerViewHolder;

import java.util.List;

/**
 * Created by pz on 2016/8/28.
 */

public class ForumRecyclerViewAdapter extends RecyclerView.Adapter<ForumRecyclerViewHolder> {

    Context context;
    List<GeneralPost> postList;

    public ForumRecyclerViewAdapter(Context context, List<GeneralPost> dataList) {
        this.context = context;
        postList = dataList;
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    @Override
    public ForumRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_general_item, parent, false);
        ForumRecyclerViewHolder viewHolder = new ForumRecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForumRecyclerViewHolder holder, int position) {
        GeneralPost post = postList.get(position);
        holder.listForumDrawee.setImageURI(post.getForum_logo());
        holder.listTitleText.setText(post.getTitle());
        holder.listUsernameText.setText(post.getUserName());
        holder.listLightText.setText(post.getLightReply() + "");
        holder.listCommentText.setText(post.getReplies() + "");
    }
}
