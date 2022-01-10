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
    private float pullY = -1f;
    private float pullX = -1f;
    Sling sling;


    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        sling.draw(canvas, getResources(), (int) 1.5, pullX, pullY);
        slingRetrun(sling.slingx, sling.slingy);

        invalidate();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        height = getHeight();
        width = getWidth();
        sling = new Sling(width / 4, 5 * height / 6);
        pullX = -1f;
        pullY = -1f;

    }

    private void slingRetrun(float slingx, float slingy) {
        float diffx = slingx - pullX;
        float diffy = slingy - pullY;

        float val = (float) (5f * Math.sqrt(2));

        float scale = (float) (Math.sqrt(diffy * diffy + diffx * diffx));
        pullX += diffx / scale * val;
        pullY += diffy / scale * val;



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            pullX = event.getX();
            pullY = event.getY();
        }


        return super.onTouchEvent(event);
    }
}
