package com.example.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {
    private TextView mTV4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        mTV4 = findViewById(R.id.tv_4);
        mTV4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); // 中划线
        mTV4.getPaint().setAntiAlias(true); // 去除锯齿

        mTV4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); // 下划线

        TextView mTV5 = findViewById(R.id.tv_5);
        mTV5.setSelected(true);
    }
}