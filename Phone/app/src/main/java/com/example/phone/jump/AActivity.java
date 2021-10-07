package com.example.phone.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.util.Util;
import com.example.phone.R;
import com.example.phone.utils.ToastUtil;

/* finish()返回上个页面
* Activity的4种启动模式launchMode（standard、singleTop、singleTask、singleInstance）
* standard 标准模式，默认 Activity是由任务栈管理的，每启动一个Activity，就会被放入栈中，按返回键，就会从栈顶移除一个Activity
* singleTop Task栈顶复用模式 当要启动的目标Activity已经位于栈顶时，不会创建新的实例，会复用栈顶的Activity，并且其onNewIntent()方法会被调用；如果目标不在栈顶，则跟standard一样创建新的实例
* singleTask Task栈内复用模式 在同一个任务栈中，如果要启动的目标Activity已经存在栈中，则会复用该Activity，并调用其onNewIntent()方法，并且该Activity上面的Activity会被清除；如果栈中没有，则创建新的实例。
* singleInstance 全局复用 不管哪个Task栈，只要存在目标Activity就复用。每个Activity占有一个新的Task栈。
* */

public class AActivity extends AppCompatActivity {
    private Button mBtnJump, mBtnJumpSelf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        Log.d("AActivity", "----onCreate----");
        Log.d("AActivity", "----taskId:"+getTaskId()+"\nhash:"+hashCode());
        logTaskName();

        mBtnJump = findViewById(R.id.btn_jump);
        mBtnJumpSelf = findViewById(R.id.btn_jump_self);

        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显式1
                Intent intent = new Intent(AActivity.this, BActivity.class);
//                intent.putExtra()
                Bundle bundle = new Bundle();
                bundle.putString("name", "测试");
                bundle.putInt("age", 100);
                intent.putExtras(bundle);
//                startActivity(intent);
                startActivityForResult(intent, 0);
                // 显式2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this, BActivity.class);
//                startActivity(intent);

                // 显式3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this, "com.example.phone.jump.BActivity");
//                startActivity(intent);

                // 显式4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this, "com.example.phone.jump.BActivity"));
//                startActivity(intent);

                // 隐式
//                Intent intent = new Intent();
//                intent.setAction("android.intent.action.BActivity");
//                startActivity(intent);
            }
        });

        mBtnJumpSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, AActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            ToastUtil.showMessage(AActivity.this, data.getExtras().getString("title"));
        }
        Log.d("AActivity", "requestCode:"+requestCode+"\nresultCode:"+resultCode);
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