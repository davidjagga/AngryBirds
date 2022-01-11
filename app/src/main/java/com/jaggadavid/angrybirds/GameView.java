package com.jaggadavid.angrybirds;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {


    private float height;
    private float width;
    private float pullY;
    private float pullX;
    private float startPullY;
    private float startPullX;
    private float totalDist;
    private boolean launch;
    boolean holding;
    Sling sling;
    Bird bird;


    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//        sling.draw(canvas, getResources(), 1, pullX, pullY, bird);
//        if (!holding) {
//            slingRetrun(sling.slingx, sling.slingy);
//            if (launch) {
//                System.out.println("launching");
//                bird.dx = 5;
//                bird.dy = -2;
//                bird.offset(5, -2);
//                bird.draw(canvas);
//
//            }
//        }
        bird.offset(5, -2);
        bird.draw(canvas);
        invalidate();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        height = getHeight();
        width = getWidth();
        sling = new Sling(width / 4, 5 * height / 6);
        bird = new Bird(-100, -100, 20f);
        bird.radius = 30f;
        pullX = sling.slingx;
        pullY = sling.slingy;
        launch = false;
        holding=false;

    }

    private void slingRetrun(float slingx, float slingy) {
        float diffx = slingx - pullX;
        float diffy = slingy - pullY;


        //float distance = (float) (Math.sqrt(diffy * diffy + diffx * diffx));
        float val = (float) (totalDist / 5f * Math.sqrt(2));
        pullX += diffx / totalDist * val;
        pullY += diffy / totalDist * val;



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            pullX = event.getX();
            pullY = event.getY();
            startPullX = event.getX();
            startPullY = event.getY();
            holding = true;
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            pullX = event.getX();
            pullY = event.getY();
            startPullX = event.getX();
            startPullY = event.getY();
            holding = true;
            float diffx = sling.slingx - startPullX;
            float diffy = sling.slingy - startPullY;
            totalDist = (float) (Math.sqrt(diffy * diffy + diffx * diffx));
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            holding = false;
            launch = true;



        }


        return true;
    }
}
