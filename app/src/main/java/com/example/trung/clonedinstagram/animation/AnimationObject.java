package com.example.trung.clonedinstagram.animation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trung.clonedinstagram.R;
import com.example.trung.clonedinstagram.interfaces.CustomAnimationListener;

/**
 * Created by Nguyen Dinh Kiem on 9/2/2015.
 * Helper animation class
 *
 */
public class AnimationObject {
    Context mContext;

    public AnimationObject(Context context){
        this.mContext = context;
    }

    public void animation(final boolean appearOrDisappear, final View view, int animationId, int delayInMillis, int durationMillis, final CustomAnimationListener customAnimationListener){
        if(mContext==null)return;
        if(view==null) return;
        final Animation animation =  AnimationUtils.loadAnimation(mContext, animationId);
        if(durationMillis!=0){
            animation.setDuration(durationMillis);
        }
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(appearOrDisappear ? View.VISIBLE :View.INVISIBLE);
                if(customAnimationListener!=null) {
                    customAnimationListener.onAnimationEnd();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        if(delayInMillis!=0){
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    view.startAnimation(animation);
                }
            },delayInMillis);
        }else {
            view.startAnimation(animation);
        }
    }

    void toggleTextAnimation(int style, final TextView textView, final String s) {
        Animation anim1 = null;
        Animation anim2 = null;
        switch (style){
            case 1:
                anim1 = AnimationUtils.loadAnimation(mContext,R.anim.fade_out_normal);
                anim1.setDuration(500);
                anim2 = AnimationUtils.loadAnimation(mContext, R.anim.fade_in_normal);
                anim2.setDuration(500);
                break;

            case 2:
                anim1 = AnimationUtils.loadAnimation(mContext,R.anim.slide_out_to_bottom);
                anim1.setDuration(500);
                anim2 = AnimationUtils.loadAnimation(mContext,R.anim.slide_in_from_top_activity);
                anim2.setDuration(500);
                break;
            default:
                anim1 = AnimationUtils.loadAnimation(mContext,R.anim.fade_out_normal);
                anim2 = AnimationUtils.loadAnimation(mContext,R.anim.fade_in_normal);
                break;

        }

        final Animation finalAnim = anim2;
        anim1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textView.setVisibility(View.INVISIBLE);
                textView.setText(s);
                textView.startAnimation(finalAnim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        anim2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        textView.startAnimation(anim1);
    }

    void animateView_slideOutToLeftSuperCrazy(final View view){
        if(mContext==null)return;
        if(view==null) return;
        Animation mAnimation1 = AnimationUtils.loadAnimation(mContext,R.anim.slide_out_to_left_crazy);
        mAnimation1.setDuration(80);
        mAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(mAnimation1);
    }

    void animateView_appearFromHellLikeDotsGame(final View view,int delay){
        if(view==null) return;
        if(view.getVisibility()==View.VISIBLE) return;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.appear_from_hell_dot1);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view.startAnimation(animation);
            }
        }, delay);

    }

    void animateView_appearFromHellLikeDotsGame2(final View view,int delay){
        if(view==null) return;
        if(view.getVisibility()==View.VISIBLE) return;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.appear_from_hell_dot2);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view.startAnimation(animation);
            }
        }, delay);

    }

    void animateView_appearFromHellLikeDotsGame3(final View view,int delay){
        if(view==null) return;
        if(view.getVisibility()==View.VISIBLE) return;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.up_level_style);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view.startAnimation(animation);
            }
        }, delay);

    }

    void animateView_disAppearToHellLikeDotsGame(final View view,int delay){
        if(view==null) return;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation mAnimation1 = AnimationUtils.loadAnimation(mContext, R.anim.disappear_to_hell_dot);
                mAnimation1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view.startAnimation(mAnimation1);
            }
        }, delay);

    }

    void animateView_appearFromHell(final View view){
        if(view==null) return;
        if(view.getVisibility()==View.VISIBLE) return;
        Animation mAnimation1 = AnimationUtils.loadAnimation(mContext,R.anim.appear_from_hell_dot);
        mAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(mAnimation1);
    }

    void animateView_appearFromHell(final View view,int delay){
        if(view==null) return;
        if(view.getVisibility()==View.VISIBLE) return;
        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation mAnimation1 = AnimationUtils.loadAnimation(mContext, R.anim.appear_from_hell_dot);
                mAnimation1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view.startAnimation(mAnimation1);
            }
        }, delay);

    }

    void animateView_disappearToHell(final View view){
        if(view==null) return;
        if(view.getVisibility()==View.INVISIBLE) return;
        Animation mAnimation1 = AnimationUtils.loadAnimation(mContext,R.anim.disappear_to_hell_dot);
        mAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(mAnimation1);
    }

    void animateView_disappearRotate(final View view){
        if(view.getVisibility()== View.INVISIBLE) return;
        Animation mAnimation1 = AnimationUtils.loadAnimation(mContext,R.anim.disappear_rotate);
        mAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(mAnimation1);
    }

    void animateView_disappearRotate2(final View view){
        if(view.getVisibility()== View.INVISIBLE) return;
        Animation mAnimation1 = AnimationUtils.loadAnimation(mContext,R.anim.disappear_rotate2);
        mAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(mAnimation1);
    }

    void animateView_slideInFromBottomVibrate(final View view){
        if(view==null) return;
        Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.slide_in_from_bottom_vibrate);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);
    }

    void animateView_slideInFromBottomSotflyBounded(final View view){
        if(view==null) return;
        Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.slide_in_from_bottom_sotfly_bound);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);
    }

    void animateView_slideInFromBottomNormal(final View view,int delay){
        if(view==null) return;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.slide_in_from_bottom);
                animation.setDuration(400);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view.startAnimation(animation);
            }
        }, delay);

    }

    void animateView_slideInFromBottomBounce(final View view,int delay){
        if(view==null) return;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.slide_in_from_bottom_bounce);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view.startAnimation(animation);
            }
        }, delay);

    }

    void animateView_slideInFromBottomSlow(final View view,int delay){
        if(view==null) return;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.slide_in_from_bottom);
                animation.setDuration(700);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view.startAnimation(animation);
            }
        }, delay);

    }

    void animateView_slideInFromRightDecelerateMedium(final View view, int delay){
        if(view==null) return;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.slide_in_from_right_decelerate_medium);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view.startAnimation(animation);
            }
        }, delay);
    }

    void animateView_slideInFromTopVibrate(final View view){
        if(view==null) return;
        Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.slide_in_from_top_vibrate);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);
    }

    void animateView_appear_stretchOut(final View view){
        if(view==null) return;
        Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.appear_stretch_out);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);
    }

    void animateView_disappear_stretchIn(final View view){
        if(view==null) return;
        Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.disappear_stretch_in);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);
    }

    void animateView_slideInFromLeftVibrate(final View view){
        if(view==null) return;
        Animation mAnimation1 = AnimationUtils.loadAnimation(mContext,R.anim.appear_from_left_vibrate);
        mAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(mAnimation1);
    }

    void animateView_slideInFromRightVibrate(final View view){
        if(view==null) return;
        Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.appear_from_right_vibrate);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);
    }

    void animateView_slideInFromRightVibrateSuperFast(final View view){
        if(view==null) return;
        Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.appear_from_right_vibrate_super_fast);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);
    }

    void animateView_slideOutToLeftCrazy(final View view){
        if(mContext==null)return;
        if(view==null) return;
        Animation mAnimation1 = AnimationUtils.loadAnimation(mContext,R.anim.slide_out_to_left_crazy);
        mAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(mAnimation1);
    }

    void animateView_slideOutToRightCrazy(final View view){
        if(mContext==null)return;
        if(view==null) return;
        Animation mAnimation1 =  AnimationUtils.loadAnimation(mContext,R.anim.slide_out_to_right_crazy);
        mAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(mAnimation1);
    }

    void animateView_slideOutToTopCrazy(final View view){
        if(mContext==null)return;
        if(view==null) return;
        Animation mAnimation1 =  AnimationUtils.loadAnimation(mContext,R.anim.slide_out_to_top_crazy);
        mAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(mAnimation1);
    }

    void animateView_slideOutToBottomCrazy(final View view){
        if(view==null) return;
        if(mContext==null)return;
        Animation mAnimation1 =  AnimationUtils.loadAnimation(mContext,R.anim.slide_out_to_bottom_crazy);
        mAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(mAnimation1);
    }

    void animateView_slideOutToBottomNormal(final View view,int delay){
        if(view==null) return;
        if(mContext==null)return;
        if(view.getVisibility()==View.INVISIBLE)return;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation mAnimation1 = AnimationUtils.loadAnimation(mContext, R.anim.slide_out_to_bottom);
                mAnimation1.setDuration(500);
                mAnimation1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view.startAnimation(mAnimation1);
            }
        }, delay);

    }

    void animateView_fadeInSlow(final View view){
        if(view==null) return;
        if(view.getVisibility()==View.VISIBLE) return;
        Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.fade_in_normal);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animation.setDuration(500);
        view.startAnimation(animation);
    }

    void animateView_fadeInSlow(final View view, int delay){
        if(view==null) return;
        Handler handler = new Handler();
        if(view.getVisibility()==View.VISIBLE) return;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.fade_in_normal);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                view.startAnimation(animation);
            }
        }, delay);

    }

    void animateView_fadeOutFast(final View view){
        if(view==null) return;
        if(view.getVisibility()==View.INVISIBLE) return;
        Animation mAnimation1 = AnimationUtils.loadAnimation(mContext,R.anim.fade_out_normal);
        mAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mAnimation1.setDuration(250);
        view.startAnimation(mAnimation1);
    }

    void animateView_fadeOutSlow(final View view){
        if(view==null) return;
        if(view.getVisibility()==View.INVISIBLE) return;
        Animation mAnimation1 = AnimationUtils.loadAnimation(mContext,R.anim.fade_out_normal);
        mAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mAnimation1.setDuration(500);
        view.startAnimation(mAnimation1);
    }

    void animateView_fadeOutVerySlow(final View view){
        if(view==null) return;
        if(view.getVisibility()==View.INVISIBLE) return;
        Animation mAnimation1 = AnimationUtils.loadAnimation(mContext,R.anim.fade_out_normal);
        mAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mAnimation1.setDuration(700);
        view.startAnimation(mAnimation1);
    }

    void animateView_fadeOutVerySlow(final View view,int delay){
        if(view==null) return;
        if(view.getVisibility()==View.INVISIBLE) return;
        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation mAnimation1 = AnimationUtils.loadAnimation(mContext, R.anim.fade_out_normal);
                mAnimation1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                mAnimation1.setDuration(2000);
                view.startAnimation(mAnimation1);
            }
        }, delay);

    }

    void animateView_slideOutToLeftSlow(final View view){
        if(view==null) return;
        Animation mAnimation1 = AnimationUtils.loadAnimation(mContext, R.anim.slide_out_to_left_slow);
        mAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(mAnimation1);
    }

    void animateView_shaking(final View view){
        if(view==null) return;
        Animation mAnimation1  = AnimationUtils.loadAnimation(mContext,R.anim.shaking);
        view.startAnimation(mAnimation1);
    }

    void animateView_vibrate5(final View view, int delay){
        if(view==null) return;
        final Animation mAnimation1  = AnimationUtils.loadAnimation(mContext,R.anim.vibrate5);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.startAnimation(mAnimation1);
            }
        },delay);

    }

    void animateView_appearStretchOutFadeInSoftly(final View view, int delay){
        if(view==null) return;
        final Animation animation  = AnimationUtils.loadAnimation(mContext,R.anim.vibrate5);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.startAnimation(animation);
            }
        },delay);

    }

    void animateView_slideInFromRightZoomIn(final View view, int delay){
        if(view==null) return;
        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation mAnimation1 = AnimationUtils.loadAnimation(mContext, R.anim.slide_in_from_right_zoomin);
                mAnimation1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view.startAnimation(mAnimation1);
            }
        }, delay);

    }

    void animateView_slideOutToLeftZoomOut(final View view, int delay){
        if(mContext==null)return;
        if(view==null) return;
        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation mAnimation1 = AnimationUtils.loadAnimation(mContext, R.anim.slide_out_to_left_zoomout);
                mAnimation1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view.startAnimation(mAnimation1);
            }
        }, delay);

    }

    public void animateView_appearNoAnimation(final View view, int delay) {
        if(view==null) return;
        Handler handler = new Handler();
        if(view.getVisibility()==View.VISIBLE) return;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.setVisibility(View.VISIBLE);
            }
        }, delay);
    }

    public void toggleImageAnimation(int style, final ImageView imageView, final Drawable image) {
        Animation anim1 = null;
        Animation anim2 = null;
        switch (style){
            case 1:
                anim1 = AnimationUtils.loadAnimation(mContext,R.anim.fade_out_normal);
                anim1.setDuration(450);
                anim2 = AnimationUtils.loadAnimation(mContext,R.anim.fade_in_normal);
                anim2.setDuration(450);
                break;
            case 2:
                anim1 = AnimationUtils.loadAnimation(mContext,R.anim.slide_out_to_bottom);
                anim1.setDuration(500);
                anim2 = AnimationUtils.loadAnimation(mContext,R.anim.slide_in_from_top_activity);
                anim2.setDuration(500);
                break;
            default:
                anim1 = AnimationUtils.loadAnimation(mContext,R.anim.fade_out_normal);
                anim1.setDuration(400);
                anim2 = AnimationUtils.loadAnimation(mContext,R.anim.fade_in_normal);
                anim2.setDuration(400);
                break;

        }

        final Animation finalAnim = anim2;
        anim1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setVisibility(View.INVISIBLE);
                imageView.setBackgroundDrawable(image);
                imageView.startAnimation(finalAnim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        anim2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.startAnimation(anim1);
    }

    public void animationUpDown(Context context, final View view) {
        final Animation animation1 = AnimationUtils.loadAnimation(context,R.anim.slide_down);
        final Animation animation2 = AnimationUtils.loadAnimation(context,R.anim.slide_up);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(animation2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(animation1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation1);
    }

//    void animationBounce(Context context, final View button, Animation.AnimationListener listener) {
//        final Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.bounce);
//        if(listener==null){
//            listener = new Animation.AnimationListener() {
//                @Override
//                public void onAnimationStart(Animation animation) {
//
//                }
//
//                @Override
//                public void onAnimationEnd(Animation animation) {
//                    if(button.getVisibility()==View.INVISIBLE) button.setVisibility(View.VISIBLE);
//                }
//
//                @Override
//                public void onAnimationRepeat(Animation animation) {
//
//                }
//            };
//        }
//        myAnim.setAnimationListener(listener);
//
//        // Use bounce interpolator with amplitude 0.2 and frequency 20
//        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.1, 20);
//        myAnim.setInterpolator(interpolator);
//
//        button.startAnimation(myAnim);
//    }

    public void animateView_vibrate(Context context, final View view) {
        if (view == null) return;
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.vibrate4);
        view.startAnimation(anim);
    }

    public void animateView_vibrate(Context context, final View view, Animation.AnimationListener listener) {
        if (view == null) return;
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.vibrate4);
        if(listener!=null) anim.setAnimationListener(listener);
        view.startAnimation(anim);
    }
}

