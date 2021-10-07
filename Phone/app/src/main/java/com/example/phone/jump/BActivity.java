package com.example.phone.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.phone.R;

public class BActivity extends AppCompatActivity {
    private TextView mTvJump;
    private Button mBtnFinish, mBtnGotoLast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Log.d("AActivity", "----onCreate----");
        Log.d("AActivity", "----taskId:"+getTaskId()+"\nhash:"+hashCode());
        logTaskName();

        mTvJump = findViewById(R.id.tv_jump);
        mBtnFinish = findViewById(R.id.btn_jump_back);
        mBtnGotoLast = findViewById(R.id.btn_jump_last_activity);

        mBtnGotoLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this, AActivity.class);
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        Integer age = bundle.getInt("age");

        mTvJump.setText(name+","+age);

        mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putString("title", "我一定会回来的！");
                intent.putExtras(bundle1);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.d("AActivity", "----onCreate----");
        Log.d("AActivity", "----taskId:"+getTaskId()+"\nhash:"+hashCode());
        logTaskName();
    }

    private void logTaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity", info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}