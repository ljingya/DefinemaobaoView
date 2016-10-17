package com.example.shuiai.defineview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author shuiai@dianjia.io
 * @Company 杭州木瓜科技有限公司
 * @date 2016/10/17
 */

public class DefineView extends View {
    private int width;
    private int height;
    private Paint mPaint;

    public DefineView(Context context) {
        this(context,null);
    }

    public DefineView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DefineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthmode == MeasureSpec.EXACTLY) {
            width = widthSize;
        }
        if (heightmode == MeasureSpec.EXACTLY) {
            height = heightSize;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(new RectF(0, 0, width, (float) (height*0.8)), 20, 20, mPaint);
        Path path = new Path();
        path.moveTo(width / 2 - 40, (float) (height*0.8));
        path.lineTo(width / 2, (float) (height*0.8 + 40));
        path.lineTo(width / 2 + 40, (float) (height*0.8));
        path.close();//形成封闭的图像
        canvas.drawPath(path, mPaint);
    }
}
