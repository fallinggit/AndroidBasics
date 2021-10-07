package com.example.phone.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.core.app.NotificationManagerCompat;

public class ToastUtil {
    public static Toast mToast;
    private static Object iNotificationManagerObj;

    public static void showMessage(Context context, String message) {
        if (message.isEmpty() || message == null) {
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        }
        else  {
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_SHORT); // 要加上显示时长 要不不显示
        }

        mToast.show();
    }

    /*
    * 通知是否可用
    **/
    private static boolean isNotificationEnable(Context context) {
        NotificationManagerCompat noManagerCompat = NotificationManagerCompat.from(context);
        return noManagerCompat.areNotificationsEnabled();
    }

    public static void hideKeyBoard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }

        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}


