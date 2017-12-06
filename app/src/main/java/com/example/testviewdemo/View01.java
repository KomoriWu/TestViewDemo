package com.example.testviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by KomoriWu
 * on 2017-12-05.
 */

public class View01 extends View {
    private Paint mPaintCircle;
    private Paint mPaintPoint;
    private Paint mPaintArc;
    private Paint mPaintPath;
    private Paint mPaintArc2;
    private Paint mPaintText;
    private Path mPath;
    private Path mPathArc;
    private RectF mRectFArc;
    private float[] mPoints = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};

    public View01(Context context) {
        super(context);
        init(context, null, 0);
    }

    public View01(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public View01(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        mPaintCircle = new Paint();
        mPaintCircle.setColor(context.getColor(R.color.colorAccent));
        mPaintCircle.setStyle(Paint.Style.FILL);
        mPaintCircle.setStrokeWidth(5);
        mPaintCircle.setAntiAlias(true);

        mPaintPoint = new Paint(mPaintCircle);
        mPaintPoint.setColor(context.getColor(R.color.colorPrimaryDark));
        mPaintPoint.setStrokeWidth(20);
        mPaintPoint.setStrokeCap(Paint.Cap.ROUND);

        mPaintArc = new Paint();
        mPaintArc.setColor(context.getColor(R.color.black));
        mPaintArc.setStyle(Paint.Style.STROKE);
        mPaintArc.setStrokeWidth(20);

        mPath = new Path();
        mPath.moveTo(100, 100);
        mPath.rLineTo(200, 0);
        mPath.rLineTo(-100, 150);
        mPath.close();
        mPaintPath = new Paint(mPaintArc);
        mPaintPath.setStyle(Paint.Style.FILL);
        mPaintPath.setStrokeWidth(5);

        mPathArc = new Path();
        mPathArc.moveTo(180, 700);
        mPathArc.rLineTo(120, 0);
        mPathArc.rLineTo(10, 37);
        mPaintArc2 = new Paint(mPaintPath);
        mPaintArc2.setStyle(Paint.Style.STROKE);
        mPaintArc2.setStrokeWidth(3);
        mPaintArc2.setTextSize(30);

        mRectFArc = new RectF(200, 700, 700, 1200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(100, 100, 100, mPaintCircle);
        canvas.drawPoint(500, 100, mPaintPoint);
        canvas.drawPoints(mPoints, 2, 12, mPaintPoint);
        canvas.drawLine(200, 10, 300, 50, mPaintCircle);
        canvas.drawArc(120, 120, 500, 500, 120, 300,
                false, mPaintArc);
        canvas.drawPath(mPath, mPaintPath);

        canvas.drawArc(mRectFArc, 180,135, true, mPaintCircle);
        canvas.drawPath(mPathArc, mPaintArc2);
        canvas.drawText("mmp", 70, 700, mPaintArc2);
    }
}
