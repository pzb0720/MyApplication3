package com.example.mylibrary.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/22 0022.
 * SharedPreferences工具类封装
 */

public class SpUtils {
    private static SharedPreferences sp;
    private static String mSpName = "share_preference_default";

    /**
     * 设置mSpName
     *
     * @param mSpName
     */
    private void setPreferencesName(String mSpName) {
        this.mSpName = mSpName;

    }

    /**
     * 写入boolean变量至sp中
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context, String key, boolean value) {
        if (sp == null) {
            sp = context.getSharedPreferences(mSpName, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).apply();
    }

    /**
     * 从sp中读取boolean标示
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(mSpName, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }

    /**
     * 写入String变量至sp中
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putString(Context context, String key, String value) {
        if (sp == null) {
            sp = context.getSharedPreferences(mSpName, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).apply();

    }

    /**
     * 从sp中读取string标示
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static String getString(Context context, String key, String defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(mSpName, Context.MODE_PRIVATE);
        }
        return sp.getString(key, defValue);
    }

    /**
     * 写入Int变量至sp中
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putInt(Context context, String key, int value) {
        if (sp == null) {
            sp = context.getSharedPreferences(mSpName, Context.MODE_PRIVATE);
        }
        sp.edit().putInt(key, value).apply();

    }

    /**
     * 从sp中读取string标示
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static int getInt(Context context, String key, int defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(mSpName, Context.MODE_PRIVATE);
        }
        return sp.getInt(key, defValue);
    }

    /**
     * 从sp中移除指定节点
     *
     * @param context
     * @param key
     */
    public static void remove(Context context, String key) {
        if (sp == null) {
            sp = context.getSharedPreferences(mSpName, Context.MODE_PRIVATE);
        }

        sp.edit().remove(key).apply();
    }


    /**
     * 保持List
     *
     * @param key
     * @param datalist
     * @param <T>
     */
    public static <T> void saveDataList(String key, List<T> datalist) {
        if (null == datalist || 0 >= datalist.size()) {
            return;
        }

        Gson gson = new Gson();
        String strJson = gson.toJson(datalist);
        SpUtils.putString(AppUtils.getContext(), key, strJson);
    }

    /**
     * 获取List
     *
     * @param key
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> List<T> getDataList(String key, Class<T> cls) {
        List<T> dataList = new ArrayList<>();
        String json = SpUtils.getString(AppUtils.getContext(), key, null);
        if (null == json) {
            return dataList;
        }
        try {
            Gson gson = new Gson();
            JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();
            for (JsonElement element : jsonArray) {
                dataList.add(gson.fromJson(element, cls));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return dataList;
    }

    public static int getThemeIndex(Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getInt("ThemeIndex",5);
    }

    public static void setThemeIndex(Context context, int index){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putInt("ThemeIndex",index).apply();
    }

    public static boolean getNightModel(Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean("pNightMode",false);
    }

    public static void setNightModel(Context context, Boolean nightModel){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean("pNightMode",nightModel).apply();
    }



}
