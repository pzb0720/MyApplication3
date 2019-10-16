package com.example.mylibrary.base.ui.widget;

import android.app.ProgressDialog;
import android.content.Context;

public class WaitProgressDialog extends ProgressDialog {
    public WaitProgressDialog(Context context) {
        this(context, 0);
    }

    public WaitProgressDialog(Context context, int theme) {
        super(context, theme);
        setCanceledOnTouchOutside(false);
    }
}
