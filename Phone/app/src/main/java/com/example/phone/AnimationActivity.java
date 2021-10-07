package com.example.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {
    private TextView mTvAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        mTvAnimation = findViewById(R.id.tv_animation);
        // 平移 translationYBy平移多少  translationY平移到多少
//        mTvAnimation.animate().translationYBy(500).setDuration(3000).start();

        // 旋转
//        mTvAnimation.animate().rotationYBy(500).setDuration(3000).start();

        // 透明度
//        mTvAnimation.animate().alpha(0).setDuration(2000).start();

//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                // 实际的值自定义 0-100
//                Log.d("aaaa", animation.getAnimatedValue() + "");
//
//                // 动画进度 0-1
//                Log.d("aaaa", "onAnimationUpdate: "+ animation.getAnimatedFraction());
//            }
//        });
//        valueAnimator.start();


        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTvAnimation, "translationY", 0, 500, 200, 100, 50, 0);
        objectAnimator.setDuration(2000);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 实际的值自定义 0-100
                Log.d("aaaa", animation.getAnimatedValue() + "");

                // 动画进度 0-1
                Log.d("aaaa", "onAnimationUpdate: " + animation.getAnimatedFraction());
            }
        });
        objectAnimator.start();
    }
}