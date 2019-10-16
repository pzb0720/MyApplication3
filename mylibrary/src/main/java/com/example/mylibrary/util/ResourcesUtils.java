package com.example.mylibrary.util;

import android.graphics.drawable.Drawable;
import android.view.View;



public class ResourcesUtils {
    /**
     * 加载布局文件
     *
     * @param layoutId
     * @return
     */
    public static View inflate(int layoutId) {
        return View.inflate(AppUtils.getContext(), layoutId, null);
    }

    /**
     * 获取drawable资源文件图片
     *
     * @param id 资源文件id
     * @return 资源文件对应图片
     */
    public static Drawable getDrawable(int id) {
        return AppUtils.getContext().getResources().getDrawable(id);
    }

    /**
     * 获取strings.xml资源文件字符串
     *
     * @param resouceId
     * @return
     */
    public static String getString(int resouceId) {
        return AppUtils.getContext().getResources().getString(resouceId);
    }
}
