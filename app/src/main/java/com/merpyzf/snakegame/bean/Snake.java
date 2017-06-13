package com.merpyzf.snakegame.bean;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;

import static com.merpyzf.snakegame.bean.Common.mBottomBorder;
import static com.merpyzf.snakegame.bean.Common.mRightBorder;

/**
 * Created by 春水碧于天 on 2017/6/12.
 */

public class Snake {
    //记录小蛇身体的第一个点
    private Point LastPoint = new Point();
    private ArrayList<Body> SnakeBodyList = new ArrayList();
    private int bodySize;


    public void addBody(Body body) {

        SnakeBodyList.add(0, body);

    }


    public void moveAction(String action) {

        bodySize = Common.mInterval;


        if (action.equals("up")) {


            if (SnakeBodyList.get(0).getX() == LastPoint.x && SnakeBodyList.get(0).getY()-bodySize == LastPoint.y) {


                actionDown();

            } else {

                actionUp();


            }


        } else if (action.equals("down")) {

            if (SnakeBodyList.get(0).getX()== LastPoint.x && SnakeBodyList.get(0).getY()+bodySize == LastPoint.y) {

                actionUp();

            } else {


                actionDown();

            }


        } else if (action.equals("left")) {


            if (SnakeBodyList.get(0).getX()-bodySize == LastPoint.x && SnakeBodyList.get(0).getY() == LastPoint.y) {
                actionRight();

            } else {

                actionLeft();


            }


        } else if (action.equals("right")) {

            if (SnakeBodyList.get(0).getX()+bodySize == LastPoint.x && SnakeBodyList.get(0).getY() == LastPoint.y) {

                actionLeft();
            } else {


                actionRight();


            }


        }


        int x = SnakeBodyList.get(0).getX()+Common.mInterval;
        int y = SnakeBodyList.get(0).getY()+Common.mInterval;
        Log.i("wk","蛇头坐标: x==>"+x+"蛇头坐标: y==>"+y+"mBottomBorder== >"+mBottomBorder);


        if(x<Common.mLeftBorder|| x> mRightBorder|| y<Common.mTopBorder|| y>Common.mBottomBorder){

            Log.i("wk","游戏结束了！！！");


        }






    }

    private void actionLeft() {

        for (int i = SnakeBodyList.size() - 1; i > 0; i--) {

            SnakeBodyList.get(i).x = SnakeBodyList.get(i - 1).x;

            SnakeBodyList.get(i).y = SnakeBodyList.get(i - 1).y;

        }

        SnakeBodyList.get(0).x -= bodySize;
        recordSnakeBodyFirstPoint();

    }

    private void actionRight() {
        for (int i = SnakeBodyList.size() - 1; i > 0; i--) {


            SnakeBodyList.get(i).x = SnakeBodyList.get(i - 1).x;

            SnakeBodyList.get(i).y = SnakeBodyList.get(i - 1).y;


        }

        SnakeBodyList.get(0).x += bodySize;
        recordSnakeBodyFirstPoint();


    }

    private void actionDown() {


        for (int i = SnakeBodyList.size() - 1; i > 0; i--) {


            SnakeBodyList.get(i).x = SnakeBodyList.get(i - 1).x;

            SnakeBodyList.get(i).y = SnakeBodyList.get(i - 1).y;
        }


        SnakeBodyList.get(0).y += bodySize;
        recordSnakeBodyFirstPoint();

    }

    private void actionUp() {

        for (int i = SnakeBodyList.size() - 1; i > 0; i--) {

            //将后一个点的值给前一个点
            SnakeBodyList.get(i).x = SnakeBodyList.get(i - 1).x;
            SnakeBodyList.get(i).y = SnakeBodyList.get(i - 1).y;

        }

        SnakeBodyList.get(0).y -= bodySize;
        recordSnakeBodyFirstPoint();
    }


    //小蛇的绘制
    public void drawSnake(Canvas canvas) {

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);


        for (int i = 0; i < SnakeBodyList.size(); i++) {

            Body body = SnakeBodyList.get(i);

            int left = body.getX() + Common.margin;
            int top = body.getY() + Common.margin;
            int right = body.getX() + Common.mInterval + Common.margin;
            int bottom = body.getY() + Common.mInterval + Common.margin;
            canvas.drawRect(left, top, right, bottom, paint);

        }


    }


    /**
     * 记录上一次移动的时候,小蛇蛇头后面的第一个点的位置，用户判断小蛇移动的过程中是否回头了
     */
    public void recordSnakeBodyFirstPoint() {

        LastPoint.x = SnakeBodyList.get(1).x;
        LastPoint.y = SnakeBodyList.get(1).y;

    }


}
