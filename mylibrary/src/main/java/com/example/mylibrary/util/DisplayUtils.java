package com.example.mylibrary.util;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.request.RequestOptions;
import com.example.mylibrary.R;

import java.io.File;

import jp.wasabeef.glide.transformations.BlurTransformation;


public class DisplayUtils {

    public static int dip2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }


    protected static int sp2px(Context context, int sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }


    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    public static int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }


    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static Bitmap bitmapResize(Bitmap src, float pxX, float pxY) {
        //压缩图片
        Matrix matrix = new Matrix();
        matrix.postScale(pxX / src.getWidth(), pxY / src.getHeight());
        Bitmap ret = Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
        return ret;
    }


    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }


    /**
     * 将px值转换为dp值
     */
    public static int px2dp(float pxValue) {
        final float scale = AppUtils.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dp值转换为px值
     */
    public static int dp2px(float dpValue) {
        final float scale = AppUtils.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值
     */
    public static int px2sp(float pxValue) {
        final float scale = AppUtils.getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将sp值转换为px值
     */
    public static int sp2px(float dpValue) {
        final float scale = AppUtils.getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidthPixels(Activity context) {
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.widthPixels;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHeightPixels(Activity context) {
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.heightPixels;
    }

    /**
     * 将一个view转换成bitmap位图
     *
     * @param view 要转换的View
     * @return view转换的bitmap
     */
    public static Bitmap viewToBitmap(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        return bitmap;
    }

    /**
     * 获取模糊虚化的bitmap
     *
     * @param context
     * @param bitmap  要模糊的图片
     * @param radius  模糊等级 >=0 && <=25
     * @return
     */
    public static Bitmap getBlurBitmap(Context context, Bitmap bitmap, int radius) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return blurBitmap(context, bitmap, radius);
        }
        return bitmap;
    }

    /**
     * android系统的模糊方法
     *
     * @param bitmap 要模糊的图片
     * @param radius 模糊等级 >=0 && <=25
     */
    public static Bitmap blurBitmap(Context context, Bitmap bitmap, int radius) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            //Let's create an empty bitmap with the same size of the bitmap we want to blur
            Bitmap outBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap
                    .Config.ARGB_8888);
            //Instantiate a new Renderscript
            RenderScript rs = RenderScript.create(context);
            //Create an Intrinsic Blur Script using the Renderscript
            ScriptIntrinsicBlur blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
            //Create the Allocations (in/out) with the Renderscript and the in/out bitmaps
            Allocation allIn = Allocation.createFromBitmap(rs, bitmap);
            Allocation allOut = Allocation.createFromBitmap(rs, outBitmap);
            //Set the radius of the blur
            blurScript.setRadius(radius);
            //Perform the Renderscript
            blurScript.setInput(allIn);
            blurScript.forEach(allOut);
            //Copy the final bitmap created by the out Allocation to the outBitmap
            allOut.copyTo(outBitmap);
            //recycle the original bitmap
            bitmap.recycle();
            //After finishing everything, we destroy the Renderscript.
            rs.destroy();
            return outBitmap;
        } else {
            return bitmap;
        }
    }

    /**
     * 显示网络虚化图片
     *
     * @param context   context
     * @param imgUrl    图片url
     * @param imageView 要显示的imageview
     */
    public static void displayBlurImg(Context context, final String imgUrl, ImageView imageView) {
        // "23":模糊度；"4":图片缩放4倍后再进行模糊
        RequestOptions options = new RequestOptions()
                .error(R.drawable.stackblur_default)
                .placeholder(R.drawable.stackblur_default)
//                .crossFade(300)
                .bitmapTransform(new BlurTransformation(23, 4));
        Glide.with(context)
                .load(imgUrl)
                .apply(options)
                .into(imageView);
    }

    /**
     * 显示本地虚化图片
     *
     * @param context   context
     * @param file      本地图片file
     * @param imageView 要显示的imageview
     */
    public static void displayBlurImg(Context context, File file, ImageView imageView) {
        // "23":模糊度；"4":图片缩放4倍后再进行模糊
//        Glide.with(context)
//                .load(file)
//                .crossFade(300)
//                .bitmapTransform(new BlurTransformation(context, 23, 4))
//                .into(imageView);
        RequestOptions options = new RequestOptions()
                .error(R.drawable.stackblur_default)
                .placeholder(R.drawable.stackblur_default)
                .transforms(new BlurTransformation(23, 4));
        Glide.with(context)
                .load(file)
                .apply(options)
                .into(imageView);
    }

    /**
     * 显示资源虚化图片
     *
     * @param context    context
     * @param resourceId 图片资源id
     * @param imageView  要显示的imageview
     */
    public static void displayBlurImg(Context context, Integer resourceId, ImageView imageView) {
        // "23":模糊度；"4":图片缩放4倍后再进行模糊

        RequestOptions options = new RequestOptions()
                .error(R.drawable.stackblur_default)
                .placeholder(R.drawable.stackblur_default)
//                .crossFade(300)
                .bitmapTransform(new BlurTransformation(23, 4));
        Glide.with(context)
                .load(resourceId)
                .apply(options)
                .into(imageView);
    }
}