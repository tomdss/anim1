package com.t3h.buoi11;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {

    private Button btnClick;
    private Button btnAlpha;
    private Button btnRotate;
    private Button btnSet;
    private Button btnTranslate;
    private Button btnScale;
    private ImageView imAnimation;
    private AnimationDrawable animation;

    private Animation alpha;
    private Animation rotate;
    private Animation scale;
    private Animation translate;
    private Animation set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnClick = findViewById(R.id.btn_click);
        btnAlpha = findViewById(R.id.btn_alpha);
        btnRotate = findViewById(R.id.btn_rotate);
        btnScale = findViewById(R.id.btn_scale);
        btnTranslate = findViewById(R.id.btn_translate);
        btnSet = findViewById(R.id.btn_set);
        imAnimation = findViewById(R.id.im_animation);
        animation = (AnimationDrawable) imAnimation.getDrawable();
        btnClick.setOnClickListener(this);
        btnAlpha.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnTranslate.setOnClickListener(this);
        btnSet.setOnClickListener(this);

        alpha = AnimationUtils.loadAnimation(this,R.anim.alpha_animation);
        rotate = AnimationUtils.loadAnimation(this,R.anim.rotate_animation);
        scale = AnimationUtils.loadAnimation(this,R.anim.scale_animation);
        translate = AnimationUtils.loadAnimation(this,R.anim.translate_animation);
        set = AnimationUtils.loadAnimation(this,R.anim.set_animation);

        alpha.setAnimationListener(this);

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.btn_click:
                if(animation.isRunning()){
                    animation.stop();
                }
                else {
                    animation.start();
                }
                break;
            case R.id.btn_alpha:
                btnAlpha.startAnimation(alpha);
                break;
            case R.id.btn_rotate:
                btnRotate.startAnimation(rotate);
                break;
            case R.id.btn_scale:
                btnScale.startAnimation(scale);
                break;
            case R.id.btn_translate:
                btnTranslate.startAnimation(translate);
                break;
            case R.id.btn_set:
                btnSet.startAnimation(set);
                break;
            default:
                break;
        }

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        if(animation.equals(alpha)){
            btnAlpha.setVisibility(View.GONE);
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
