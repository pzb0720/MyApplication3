package com.example.myapplication.util;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Administrator on 2019/1/3 0003.
 */

public class BackgroundColor {
    /**
     * Tab colors
     */
    private static final int[] TAB_COLORS = new int[]{
            Color.parseColor("#90C5F0"),
            Color.parseColor("#91CED5"),
            Color.parseColor("#F88F55"),
            Color.parseColor("#C0AFD0"),
            Color.parseColor("#E78F8F"),
            Color.parseColor("#67CCB7"),
            Color.parseColor("#F6BC7E")
    };

    public static int randomTagColor() {
        int randomNum = new Random().nextInt();
        int position = randomNum % TAB_COLORS.length;
        if (position < 0) {
            position = -position;
        }
        return TAB_COLORS[position];
    }

}
