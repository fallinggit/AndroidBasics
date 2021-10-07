package com.example.phone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.phone.utils.ToastUtil;

public class ProgressActivity extends AppCompatActivity {
    private ProgressBar mPb3;
    private Button mBtnProgressStart, mBtnProgressReset;
    private Button mBtnPd1, mBtnPd2;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        mPb3 = findViewById(R.id.progress_bar3);
        mPb3.setProgress(90);

        mBtnProgressStart = findViewById(R.id.btn_progress_start);
        mBtnProgressReset = findViewById(R.id.btn_progress_reset);

        mBtnPd1 = findViewById(R.id.btn_progress_dl1);
        mBtnPd2 = findViewById(R.id.btn_progress_dl2);
        mBtnProgressStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });

        mBtnProgressReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPb3.setProgress(0);
            }
        });

        mBtnPd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 旋转
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showMessage(ProgressActivity.this, "取消");
                    }
                });
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        progressDialog.dismiss();
                    }
                });
                progressDialog.setCancelable(false);
                progressDialog.show();
            }
        });
        mBtnPd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 进度
                progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在下载...");
                progressDialog.show();
                handlerDialog.sendEmptyMessage(1);
            }
        });
    }

    Handler handlerDialog = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            if (progressDialog.getProgress() < 100) {
                handlerDialog.postDelayed(runnableDialog, 500);
            }
            else  {
                ToastUtil.showMessage(ProgressActivity.this, "加载完成");
            }
        }
    };

    Runnable runnableDialog = new Runnable() {
        @Override
        public void run() {
            progressDialog.setProgress(progressDialog.getProgress() + 10);
            handlerDialog.sendEmptyMessage(1);
        }
    };

    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            if (mPb3.getProgress() < 100) {
                handler.postDelayed(runnable, 500);
            }
            else {
                ToastUtil.showMessage(ProgressActivity.this, "加载完成");
                progressDialog.dismiss();
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mPb3.setProgress(mPb3.getProgress() + 5);
            handler.sendEmptyMessage(0);
        }
    };
}