package com.example.phone.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.phone.MainActivity;
import com.example.phone.R;

public class RecycleViewActivity extends AppCompatActivity {
    private Button mBtnLinear, mBtnHor, mBtnGrid, mBtnWaterFall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        mBtnLinear = findViewById(R.id.btn_linear);
        mBtnHor = findViewById(R.id.btn_hor);
        mBtnGrid = findViewById(R.id.btn_grid);
        mBtnWaterFall = findViewById(R.id.btn_waterfall);

        mBtnLinear.setOnClickListener(v -> {
            Intent intent = new Intent(RecycleViewActivity.this, LinearRecycleViewActivity.class);
            startActivity(intent);
        });

        mBtnHor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this, HorRecycleViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this, GridRecycleViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnWaterFall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this, WaterFallRecycleViewActivity.class);
                startActivity(intent);
            }
        });
    }
}