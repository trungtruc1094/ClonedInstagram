package com.example.trung.clonedinstagram;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements FeedAdapter.OnFeedItemClickListener {
    @BindView(R.id.toolbar)
    RelativeLayout toolbar;
    @BindView(R.id.rvFeed)
    RecyclerView rvFeed;
    @BindView(R.id.btnCreate)
    ImageButton btnCreate;
    @BindView(R.id.ivLogo)
    ImageView ivLogo;
    @BindView(R.id.inboxMenuItem)
    ImageButton inboxMenuItem;

    boolean pendingIntroAnimation = false;
    private static final int ANIM_DURATION_TOOLBAR = 300;
    private static final int ANIM_DURATION_FAB = 400;

//    RecyclerView rvFeed;


    private FeedAdapter feedAdapter;
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        MenuItem inboxMenuItem = menu.findItem(R.id.action_inbox);
//        inboxMenuItem.setActionView(R.layout.menu_item_view);
//        return true;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        rvFeed = (RecyclerView) findViewById(R.id.rvFeed);

        if (savedInstanceState == null) {
            pendingIntroAnimation = true;
        }

        setupIntialAnimation();
        setupFeed();
    }

    private void setupIntialAnimation() {
        if (pendingIntroAnimation) {
            pendingIntroAnimation = false;
            startInitialAnimation();
        }
    }

    private void setupFeed() {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvFeed.setLayoutManager(linearLayoutManager);

        feedAdapter = new FeedAdapter(this);
        feedAdapter.setOnFeedItemClickListener(this);
        rvFeed.setAdapter(feedAdapter);
    }

    // Start initial Animation
    public void startInitialAnimation(){
        // Set all views being out of screen
        btnCreate.setTranslationY(2 * getResources().getDimensionPixelOffset(R.dimen.btn_fab_size));

        int actionbarSize = Utils.dpToPx(56);
        toolbar.setTranslationY(-actionbarSize);
        ivLogo.setTranslationY(-actionbarSize);
        inboxMenuItem.setTranslationY(-actionbarSize);

        // Start animation
        toolbar.animate()
                .translationY(0)
                .setDuration(ANIM_DURATION_TOOLBAR)
                .setStartDelay(300);
        ivLogo.animate()
                .translationY(0)
                .setDuration(ANIM_DURATION_TOOLBAR)
                .setStartDelay(400);
        inboxMenuItem.animate()
                .translationY(0)
                .setDuration(ANIM_DURATION_TOOLBAR)
                .setStartDelay(500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        startContentAnimation();
                    }
                })
                /*.setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        startContentAnimation();
                    }
                })*/
                .start();
    }

    // Start content animation
    public void startContentAnimation(){
        btnCreate.animate()
                .translationY(0)
                .setInterpolator(new OvershootInterpolator(1.f))
                .setStartDelay(300)
                .setDuration(ANIM_DURATION_FAB)
                .start();
        feedAdapter.updateItems();
    }

    @Override
    public void onCommentsClick(View view, int position) {
        final Intent intent = new Intent(this, CommentsActivity.class);

        //Get location on screen for tapped view
        int[] startingLocation = new int[2];
        view.getLocationOnScreen(startingLocation);
        intent.putExtra(CommentsActivity.ARG_DRAWING_START_LOCATION, startingLocation[1]);

        startActivity(intent);
        // Disable enter transition for new activity
        overridePendingTransition(0, 0);
    }
}
