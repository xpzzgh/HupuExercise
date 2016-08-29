package com.example.pz.hupuexercise.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by pz on 2016/8/28.
 */

public class ForumRecyclerView extends RecyclerView {
    boolean isScrollToBottom;   //翻到下面
    OnLoadMoreListener listener;

    public ForumRecyclerView(Context context) {
        super(context);
    }

    public ForumRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ForumRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.listener = loadMoreListener;
    }

    @Override
    public void onScrolled(int dx, int dy) {
        if(dy < 0) {
            //往上翻的时候显示
            isScrollToBottom = false;
        }else {
            //往下翻的时候隐藏
            isScrollToBottom = true;
        }
    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
        if(isScrollToBottom && state == RecyclerView.SCROLL_STATE_IDLE) {
            LinearLayoutManager layoutManager = (LinearLayoutManager) getLayoutManager();
            int lastItem = layoutManager.findLastVisibleItemPosition();
            int itemCount = layoutManager.getItemCount();
            if(lastItem == (itemCount-1)) {
                listener.loadMore();
            }
        }
    }

    public interface OnLoadMoreListener {
        public void loadMore();
    }
}
