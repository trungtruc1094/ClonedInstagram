package com.example.trung.clonedinstagram;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.example.trung.clonedinstagram.view.SquaredImageView;
import com.example.trung.clonedinstagram.Utils;

import com.facebook.rebound.ui.Util;

import java.net.Inet4Address;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    private static final int ANIMATED_ITEMS_COUNT = 2;

    private Context context;
    private int lastAnimatedPosition = -1;
    private int itemsCount = 10;

    private OnFeedItemClickListener onFeedItemClickListener;

    public FeedAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_feed, parent, false);
        return new CellFeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        runEnterAnimation(viewHolder.itemView, position);
        CellFeedViewHolder holder = (CellFeedViewHolder) viewHolder;
        if (position % 2 == 0) {
            holder.ivFeedCenter.setImageResource(R.drawable.img_feed_center_1);
            holder.ivFeedBottom.setImageResource(R.drawable.img_feed_bottom_1);
        } else {
            holder.ivFeedCenter.setImageResource(R.drawable.img_feed_center_2);
            holder.ivFeedBottom.setImageResource(R.drawable.img_feed_bottom_2);
        }
        holder.ivFeedBottom.setOnClickListener(this);
        holder.ivFeedBottom.setTag(position);
    }

    @Override
    public int getItemCount() {
        return itemsCount;
    }



    // Enter Animation
    public void runEnterAnimation(View view, int position){
        if (position >= ANIMATED_ITEMS_COUNT - 1) {
            return;
        }

        if (position > lastAnimatedPosition){
            lastAnimatedPosition = position;
            view.setTranslationY(Utils.getScreenHeight(context));
            view.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3.f)).setDuration(700).start();
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ivFeedBottom){
            // Check if onFeedItemClickListener has value
            if (onFeedItemClickListener != null){
                onFeedItemClickListener.onCommentsClick(view, (Integer) view.getTag());
            }
        }
    }

    // Khoi tao interface
    public void setOnFeedItemClickListener(OnFeedItemClickListener onFeedItemClickListener){
        this.onFeedItemClickListener = onFeedItemClickListener;
    }


    public static class CellFeedViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivFeedCenter) SquaredImageView ivFeedCenter;
        @BindView(R.id.ivFeedBottom) ImageView ivFeedBottom;

        public CellFeedViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void updateItems() {
        itemsCount = 10;
        notifyDataSetChanged();
    }

    // Create interface
    public interface OnFeedItemClickListener{
        public void onCommentsClick(View view, int position);
    }
}
