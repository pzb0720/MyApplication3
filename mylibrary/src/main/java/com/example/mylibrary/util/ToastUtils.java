package com.example.mylibrary.util;

import android.content.Context;
import android.widget.Toast;


public class ToastUtils {

    private static Toast mToast = null;

    /**
     * 显示一个toast提示
     *
     * @param resourceId toast字符串资源id
     */
    public static void showToast(int resourceId) {
        showToast(ResourcesUtils.getString(resourceId));
    }

    /**
     * 显示一个toast提示
     *
     * @param msg
     */
    public static void showToast(String msg) {
        showToast(msg, Toast.LENGTH_LONG);
    }

    /**
     * 显示一个toast提示
     *
     * @param msg
     * @param lengthLong
     */
    public static void showToast(String msg, int lengthLong) {
        showToast(AppUtils.getContext(), msg, lengthLong);
    }

    /**
     * @param mContext
     * @param msg
     * @param lengthLong
     */
    public static void showToast(final Context mContext, final String msg, final int lengthLong) {
        AppUtils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                if (mToast == null) {
                    mToast = Toast.makeText(mContext, msg, lengthLong);
                } else {
                    mToast.setText(msg);
                    mToast.setDuration(lengthLong);
                }
                mToast.show();
            }
        });
    }
}
