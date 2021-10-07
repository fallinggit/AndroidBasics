package com.example.phone.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyBoardUtils {
    /**
     * 显示键盘
     * @param view
     */
    public static void showKeyboard(View view) {
        if (view != null) {
            // view不为空 通过view上下文
            Context context = view.getContext();
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            view.requestFocus();
            inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    /**
     * 隐藏键盘
     * @param view
     */
    public static void hideKeyboard(View view) {
        if (view != null) {
            // view不为空 通过view上下文
            Context context = view.getContext();
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);

            // 表示软键盘窗口总是隐藏 除非开始时以SHOW_FORCED显示
            /* 0 SHOW_IMPLICIT SHOW_FORCED
             * 如果隐藏软键盘时使用的flag为HIDE_IMPLICIT_ONLY，
             * 那么软键盘只有在非用户显式的显示的时候才隐藏，
             * 这意味着如果隐藏软键盘时使用的flag为HIDE_IMPLICIT_ONLY，
             * 那么只有当显示软键盘时指定的flag为SHOW_IMPLICIT时，软键盘才会隐藏，
             * 如果显示软键盘时指定的flag不是SHOW_IMPLICIT，而是0或者SHOW_FORCED，那么软键盘就不会隐藏。
             * */
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
