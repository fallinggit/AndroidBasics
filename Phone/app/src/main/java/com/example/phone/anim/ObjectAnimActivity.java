package com.example.phone.anim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.phone.R;

public class ObjectAnimActivity extends AppCompatActivity {

    private TextView mTvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);

        mTvTest = findViewById(R.id.tv);
        mTvTest.animate().rotationBy(500).setDuration(2000).start();
        mTvTest.animate().rotationXBy(500).setDuration(2000).start();
        mTvTest.animate().rotationYBy(500).setDuration(2000).start();
        mTvTest.animate().translationXBy(500).setDuration(2000).start();
        mTvTest.animate().translationYBy(500).setDuration(2000).start();
        //mTvTest.animate().scaleXBy(500).setDuration(2000).start();
        //mTvTest.animate().scaleYBy(500).setDuration(2000).start();
        mTvTest.animate().alpha(0).setDuration(2000).start();
    }
}