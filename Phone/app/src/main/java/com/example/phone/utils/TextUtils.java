package com.example.phone.utils;

import androidx.annotation.Nullable;

public class TextUtils {
    public  static boolean isEmpty(@Nullable CharSequence str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        else
        return false;
    }

}
