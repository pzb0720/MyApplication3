package com.example.myapplication.util;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.text.DecimalFormat;

public class CacheDataManager {
    public static String getCacheSize(Context context) {

        Long cacheSize = getFolderSize(context.getCacheDir());
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            cacheSize += getFolderSize(context.getExternalCacheDir());
        }

        return getFormatSize(cacheSize);
    }

    private static Long getFolderSize(File file) {
        long size = 0;
        try {
            File[] fileLists = file.listFiles();
            for (int i = 0; i < fileLists.length; i++) {
                if (fileLists[i].isDirectory()) {
                    size += getFolderSize(fileLists[i]);
                } else {
                    size += fileLists[i].length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;

    }

    /**
     * 格式化单位
     */
    public static String getFormatSize(double size) {
//        double kiloByte = size / 1024;
//        if (kiloByte < 1) {
//            return String.valueOf(size) + "Byte";
//        }
//        double megaByte = kiloByte / 1024;
//
//
//        if (megaByte < 1) {
//            double result1 = BigDecimal.;
//            return result1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB"
//        }
//
//        return null;

        //获取到的size为：1705230
        int TB = 1024 * 1024 * 1024 * 1024;//定义TB的计算常量
        int GB = 1024 * 1024 * 1024;//定义GB的计算常量
        int MB = 1024 * 1024;//定义MB的计算常量
        int KB = 1024;//定义KB的计算常量
        DecimalFormat df = new DecimalFormat("0.00");//格式化小数
        String resultSize = "";
        if (size / TB >= 1) {
            resultSize = df.format(size / (float) TB) + "TB   ";
        } else if (size / GB >= 1) {
            //如果当前Byte的值大于等于1GB
            resultSize = df.format(size / (float) GB) + "GB   ";
        } else if (size / MB >= 1) {
            //如果当前Byte的值大于等于1MB
            resultSize = df.format(size / (float) MB) + "MB   ";
        } else if (size / KB >= 1) {
            //如果当前Byte的值大于等于1KB
            resultSize = df.format(size / (float) KB) + "KB   ";
        } else {
            resultSize = size + "B   ";
        }
        return resultSize;
    }
}
