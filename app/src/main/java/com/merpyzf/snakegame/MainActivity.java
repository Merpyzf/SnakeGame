package com.merpyzf.snakegame;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.merpyzf.snakegame.bean.Body;
import com.merpyzf.snakegame.bean.Common;
import com.merpyzf.snakegame.bean.Snake;
import com.merpyzf.snakegame.view.SnakeView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private SnakeView mSnakeView;
    private int mInterval = 0;
    private String mAction = "right";
    private Timer mTimer;
    private Snake mSnake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSnakeView = (SnakeView) findViewById(R.id.snakeView);
        mSnake = new Snake();
        mSnakeView.setmSnake(mSnake);
        mInterval = Common.mInterval;
        mSnake.addBody(new Body(mInterval*3, 0, Color.BLUE));
        mSnake.addBody(new Body(mInterval*3, mInterval, Color.BLUE));
        mSnake.addBody(new Body(mInterval*3, mInterval * 2, Color.BLUE));


        mTimer = new Timer();

        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {


                mSnake.moveAction(mAction);
                mSnakeView.postInvalidate();


            }
        }, 300, 500);


    }

    public void clickUp(View v) {

        mAction = "up";

    }

    public void clickDown(View v) {

        mAction = "down";

    }

    public void clickLeft(View v) {

        mAction = "left";

    }

    public void clickRight(View v) {

        mAction = "right";

    }

    @Override
    protected void onDestroy() {
        mTimer.cancel();
        super.onDestroy();
    }
}
