package com.example.phone;

import android.app.Activity;
import android.view.View;

import com.example.phone.utils.ToastUtil;

public class MyClickListener implements View.OnClickListener {
    private Activity mActivity;

    public MyClickListener(Activity activity) {
        this.mActivity = activity;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        ToastUtil.showMessage(mActivity, "事件源所在的外部类实现");
    }
}
