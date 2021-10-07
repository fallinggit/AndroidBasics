package com.example.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class LifeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        Log.d("LifeCycle", "------onCreate------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "------onStart------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "------onResume------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "------onPause------");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "------onRestart------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "------onDestroy------");
    }
}