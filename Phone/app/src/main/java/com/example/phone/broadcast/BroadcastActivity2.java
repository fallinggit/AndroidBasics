package com.example.phone.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.phone.R;
import com.example.phone.utils.ToastUtil;

public class BroadcastActivity2 extends AppCompatActivity {
    private Button mBtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast2);

        mBtn2 = findViewById(R.id.btn_broadcast2);
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("update");
                LocalBroadcastManager.getInstance(BroadcastActivity2.this).sendBroadcast(intent);
                ToastUtil.showMessage(BroadcastActivity2.this, "发送本地广播成功");
                finish();
            }
        });
    }
}