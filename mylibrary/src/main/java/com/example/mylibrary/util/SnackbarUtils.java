package com.example.mylibrary.util;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Administrator on 2018/12/8 0008.
 */

public class SnackbarUtils {
    public static void setMessage(View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
//        snackbar.getView().setBackgroundColor(AppUtils.getContext().getResources().getColor(R.color.txt_black));
        snackbar.show();
    }

}
