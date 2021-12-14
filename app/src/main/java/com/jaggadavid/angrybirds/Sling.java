package com.jaggadavid.angrybirds;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import androidx.core.content.ContextCompat;

public class Sling extends RectF {



    public Sling(float length, float width, float x, float y) {
        super(x, y, x+width, y+length);

    }

    public void draw(Canvas canvas, int color) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(centerX()-width()/2, centerY()-height()/2,centerX()+width()/2,centerY()+height()/2, paint);

        canvas.drawCircle(centerX(), centerY()-height()/2, width()/2, paint);
    }

}
