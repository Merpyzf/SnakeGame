package com.merpyzf.snakegame.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.merpyzf.snakegame.bean.Common;
import com.merpyzf.snakegame.bean.Snake;


/**
 * Snake
 * 1.在SnakeView里面给Snake对象设置上下左右边界
 *
 * @author wangke
 */
public class SnakeView extends View {

    private int mGameWidth;
    private int mGameHeight;
    private int mInterval;
    private int MaxLines = 18;
    private Paint mPaint = null;
    //游戏背景方格距离上下左右的间距
    private int margin = Common.margin;


    private Snake mSnake;

    public Snake getmSnake() {
        return mSnake;
    }

    public void setmSnake(Snake mSnake) {
        this.mSnake = mSnake;
    }

    public SnakeView(Context context) {
        super(context);
    }

    public SnakeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.parseColor("#5933b5e5"));
        init();

    }

    private void init() {

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#666666"));

    }

    public SnakeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        Log.i("wk", "==>onMeasure()");


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:

                Log.i("wk","X: "+event.getX()+"Y: "+event.getY());

                break;


        }




        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mGameWidth = w;
        mGameHeight = h;
        Log.i("wk", "窗体的宽度:" + mGameWidth);
        Log.i("wk", "窗体的高度:" + mGameHeight);

        Log.i("wk", "==>onSizeChanged()");

        mInterval = (int) (((Math.min(w, h)) -(2*margin)) * 1.0f/ MaxLines);

        Common.mInterval = (int) mInterval;


        Log.i("wk", "总共要打印的行数==>" + MaxLines);

        //计算贪吃蛇能够移动的上下左右边距
        Common.mTopBorder = margin;
        Common.mLeftBorder = margin;
        Common.mBottomBorder = (int) (mInterval*(MaxLines));
        Common.mRightBorder = (int) (mInterval*(MaxLines));

    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        drawGameBg(canvas);
        mSnake.drawSnake(canvas);


    }

    /**
     * 绘制游戏方格背景
     *
     * @param canvas
     */
    private void drawGameBg(Canvas canvas) {

        for (int i = 0; i <=MaxLines; i++) {

            int startX = margin;
            int stopX = mGameWidth - margin;
            int startY = margin;
            int stopY = (int) (MaxLines*mInterval+margin);
            canvas.drawLine(margin + (mInterval * i), startY, margin+(mInterval * i), stopY, mPaint);
            canvas.drawLine(startX, margin + (mInterval * i), stopX, margin + (mInterval * i), mPaint);


        }


    }
}
