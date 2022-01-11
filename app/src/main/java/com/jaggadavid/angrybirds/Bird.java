package com.jaggadavid.angrybirds;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.provider.Settings;

public class Bird extends RectF {
    public float radius;
    Paint paint;
    float dx,dy;
    public Bird(float left, float top, float right, float bottom, float radiusVal) {

        super(left, top, right, bottom);
        radius = radiusVal;
        paint = new Paint(Color.RED);
        dx=0f;
        dy=0f;
    }
    public Bird(float cx, float cy, float radius) {
        this(cx-radius, cy-radius, cx+radius, cy+radius, radius);
    }
    public void draw(Canvas canvas){
        paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle(centerX(), centerY(), radius, paint);
    }



}
