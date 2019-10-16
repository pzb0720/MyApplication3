package com.example.myapplication.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;


public class MyColorCircleView extends View {
    Paint circlePaint;
    Paint fillPaint;
    String TAG = "哇哈哈 MyColorCircleView";
    int width;
    int height;

    public MyColorCircleView(Context context) {
        this(context, null);
    }

    public MyColorCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public MyColorCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        circlePaint = new Paint();
        circlePaint.setColor(getResources().getColor(R.color.black));
        circlePaint.setAntiAlias(true);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(3.0f);

        fillPaint = new Paint();
        fillPaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);
        fillPaint.setColor(getResources().getColor(android.R.color.holo_red_dark));

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "onDraw: " + width + "height" + height);


        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2 - 3.0f), fillPaint);

        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2 - 3.0f), circlePaint);

    }

    public void setCircleColor(int color) {
        fillPaint.setColor(color);
        invalidate();
    }


    public void setViewIsSelect(boolean select) {
        if (select) {
            circlePaint.setColor(getResources().getColor(android.R.color.black));
        } else {
            circlePaint.setColor(getResources().getColor(android.R.color.transparent));
        }
        invalidate();
    }


}
