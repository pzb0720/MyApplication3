package com.example.myapplication.ui.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;

/**
 * Created by Administrator on 2018/12/7 0007.
 */

public class CustomPopupWindow extends PopupWindow {
    View mContentView;
    View mParentView;
    private CustomPopupWindowListener mListener;
    private Boolean mIsWrap;
    private boolean mIsOutsideTouch;
    private boolean mIsFocus;
    private Drawable mBackgroundDrawable;
    private int mAnimationStyle;


    public CustomPopupWindow(Builder builder) {
        this.mContentView = builder.contentView;
        this.mParentView = builder.parentView;
        this.mListener = builder.listener;
        this.mIsFocus = builder.isFocus;
        this.mIsOutsideTouch = builder.isOutsideTouch;
        this.mBackgroundDrawable = builder.backgroundDrawable;
        this.mAnimationStyle = builder.animationStyle;
        this.mIsWrap = builder.isWrap;
        initLayout();
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initLayout() {
        mListener.initPopView(mContentView);
        setWidth(mIsWrap ? LayoutParams.WRAP_CONTENT : LayoutParams.MATCH_PARENT);
        setHeight(mIsWrap ? LayoutParams.WRAP_CONTENT : LayoutParams.MATCH_PARENT);
        setOutsideTouchable(mIsOutsideTouch);
        setFocusable(mIsFocus);
        setBackgroundDrawable(mBackgroundDrawable);
        //如果设置了动画则使用动画

        if (mAnimationStyle != -1) {
            setAnimationStyle(mAnimationStyle);
        }
        setContentView(mContentView);
    }

    /**
     * 获得用于展示popup内容的view
     *
     * @return
     */
    @Override
    public View getContentView() {
        return mContentView;
    }

    /**
     * 用于填充contentView,必须传ContextThemeWrapper(比如activity)不然popupwindow要报错
     *
     * @param context
     * @param layoutId
     * @return
     */
    public static View inflateView(Context context, int layoutId) {
        return LayoutInflater.from(context).inflate(layoutId, null);
    }

    /**
     * //默认显示到中间
     */
    public void show() {
        if (mParentView == null) {
            showAtLocation(mContentView, Gravity.CENTER, 0, 0);
        } else {
            showAtLocation(mParentView, Gravity.CENTER, 0, 0);
        }
    }


    public static final class Builder {

        private View contentView;
        private View parentView;
        private boolean isFocus = true;
        private boolean isOutsideTouch = true;
        private CustomPopupWindowListener listener;

        private Drawable backgroundDrawable = new ColorDrawable(0x00000000);
        private int animationStyle = -1;
        private boolean isWrap;

        private Builder() {
        }

        public Builder contentView(View contentView) {
            this.contentView = contentView;
            return this;
        }

        public Builder parentView(View parentView) {
            this.parentView = parentView;
            return this;
        }

        public Builder isWrap(boolean isWrap) {
            this.isWrap = isWrap;
            return this;
        }


        public Builder customListener(CustomPopupWindowListener listener) {
            this.listener = listener;
            return this;
        }


        public Builder isOutsideTouch(boolean isOutsideTouch) {
            this.isOutsideTouch = isOutsideTouch;
            return this;
        }

        public Builder isFocus(boolean isFocus) {
            this.isFocus = isFocus;
            return this;
        }

        public Builder backgroundDrawable(Drawable backgroundDrawable) {
            this.backgroundDrawable = backgroundDrawable;
            return this;
        }

        public Builder animationStyle(int animationStyle) {
            this.animationStyle = animationStyle;
            return this;
        }

        public CustomPopupWindow build() {
            if (contentView == null) {
                throw new IllegalStateException("ContentView is required");
            }
            if (listener == null) {
                throw new IllegalStateException("CustomPopupWindowListener is required");
            }

            return new CustomPopupWindow(this);
        }

    }

    public interface CustomPopupWindowListener {
        void initPopView(View contentView);
    }
}
