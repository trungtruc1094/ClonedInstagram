package com.example.trung.clonedinstagram;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommentsActivity extends AppCompatActivity {
    public static final String ARG_DRAWING_START_LOCATION = "arg_drawing_start_location";

    @BindView(R.id.toolbar)
    RelativeLayout toolbar;

    @BindView(R.id.rootContent)
    LinearLayout rootContent;

    @BindView(R.id.rvComments)
    RecyclerView rvComments;

    @BindView(R.id.llAddComment)
    LinearLayout llAddComment;

    private CommentAdapter commentAdapter;
    private int drawingStartLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        ButterKnife.bind(this);
        setUpComments();

        drawingStartLocation = getIntent().getIntExtra(ARG_DRAWING_START_LOCATION, 0);
        if (savedInstanceState == null) {
            rootContent.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    rootContent.getViewTreeObserver().removeOnPreDrawListener(this);
                    startIntroAnimation();
                    return true;
                }
            });
        }
    }

    private void setUpComments() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvComments.setLayoutManager(linearLayoutManager);
        rvComments.setHasFixedSize(true);

        commentAdapter = new CommentAdapter(this);
        rvComments.setAdapter(commentAdapter);
        rvComments.setOverScrollMode(View.OVER_SCROLL_NEVER);

        rvComments.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING){
                    commentAdapter.setAnimationsLocked(true);
                }
            }
        });
    }

    @OnClick(R.id.btnSendComment)
    public void onSendCommentClick(){
        commentAdapter.addItem();
        commentAdapter.setAnimationsLocked(false);
        commentAdapter.setDelayEnterAnimation(false);
        rvComments.smoothScrollBy(0, rvComments.getChildAt(0).getHeight() * commentAdapter.getItemCount());
    }

    private void startIntroAnimation() {
        // Fixed positions of elements
        rootContent.setScaleY(0.1f);
        rootContent.setPivotY(drawingStartLocation);

        llAddComment.setTranslationY(100);

        // Start animation
        rootContent.animate()
                .scaleY(1)
                .setDuration(200)
                .setInterpolator(new AccelerateInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        animateContent();
                    }
                })
                .start();
    }

    private void animateContent() {
        commentAdapter.updateItems();
        llAddComment.animate().translationY(0)
                .setInterpolator(new DecelerateInterpolator())
                .setDuration(200)
                .start();
    }

    @Override
    public void onBackPressed() {
        rootContent.animate()
                .translationY(Utils.getScreenHeight(this))
                .setDuration(200)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        CommentsActivity.super.onBackPressed();
                        overridePendingTransition(0,0);
                    }
                })
                .start();
    }
}
