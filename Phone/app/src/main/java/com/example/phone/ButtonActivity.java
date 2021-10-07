package com.example.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class ButtonActivity extends AppCompatActivity {
    private Button mBtn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        // android:foreground="?selectableItemBackground" 水波纹 无圆角

        mBtn3 = findViewById(R.id.btn_3);
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 此时this代表button
                makeText(ButtonActivity.this, "btn3点击", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showToast(View view) {
        // 此时this代表ButtonActivity
        makeText(this, "btn4你点我干嘛", Toast.LENGTH_SHORT).show();
    }
}