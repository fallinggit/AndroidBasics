package com.example.phone.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CpuUsageInfo;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.phone.R;
import com.example.phone.utils.TextUtils;

public class CustomDialog extends Dialog implements Button.OnClickListener {
    private TextView mTvTitle, mTvMessage;
    private TextView mBtnConfirm, mBtnCancel;
    private String title, message, cancel, confirm;
    private IOnCancelListener cancelListener;
    private IOnConfirmListener confirmListener;
    /**
     * Creates a dialog window that uses a custom dialog style.
     * <p>
     * The supplied {@code context} is used to obtain the window manager and
     * base theme used to present the dialog.
     * <p>
     * The supplied {@code theme} is applied on top of the context's theme. See
     * <a href="{@docRoot}guide/topics/resources/available-resources.html#stylesandthemes">
     * Style and Theme Resources</a> for more information about defining and
     * using styles.
     *
     * @param context    the context in which the dialog should run
     * @param themeResId a style resource describing the theme to use for the
     *                   window, or {@code 0} to use the default dialog theme
     */
    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public CustomDialog setTitle(String title) {
        this.title = title;

        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;

        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener cancelListener) {
        this.cancel = cancel;
        this.cancelListener = cancelListener;

        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener confirmListener) {
        this.confirm = confirm;
        this.confirmListener = confirmListener;

        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_custom);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  //圆角起作用
//        getWindow().setDimAmount(0f); // 设置透明度

        // 设置宽度
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x * 0.8); // 设置dialog的宽度为当前手机屏幕宽度的80%
        getWindow().setAttributes(p);

        mTvTitle = findViewById(R.id.tv_title);
        mTvMessage = findViewById(R.id.tv_message);
        mBtnCancel = findViewById(R.id.btn_cancel);
        mBtnConfirm = findViewById(R.id.btn_done);
        mTvTitle.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD)); // 设置粗体

        if (!TextUtils.isEmpty(title)) {
            mTvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(message)) {
            mTvMessage.setText(message);
        }
        if (!TextUtils.isEmpty(cancel)) {
            mBtnCancel.setText(cancel);
        }
        if (!TextUtils.isEmpty(confirm)) {
            mBtnConfirm.setText(confirm);
        }

        mBtnCancel.setOnClickListener(this);
        mBtnConfirm.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                if (cancelListener != null) {
                    cancelListener.onCancel(this);
                    dismiss();
                }
                break;
            case R.id.btn_done:
                if (confirmListener != null) {
                    confirmListener.onConfirm(this);
                    dismiss();
                }
                break;
        }
    }

    public interface IOnCancelListener {
        void onCancel(CustomDialog dialog);
    }
    public interface IOnConfirmListener {
        void onConfirm(CustomDialog dialog);
    }
}
