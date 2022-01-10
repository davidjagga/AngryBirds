package com.jaggadavid.angrybirds;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import androidx.core.content.ContextCompat;

public class Sling extends RectF {

    int angleTilt;
    public float slingx, slingy;

    public Sling(float length, float width, float x, float y) {
        super(x, y, x+width, y+length);
        slingx = 0;
        slingy = 0;

    }

    public Sling(float x, float y) {
        super(x, y, x+25, y+100);
    }

    public void draw(Canvas canvas, Resources color, int tilt, float pullx, float pully) {
        //add to recs with two color
        Paint paint = new Paint();
        paint.setColor(color.getColor(R.color.brown));
        //bottom sling
        canvas.drawRect(centerX()-width()/2, centerY()-height()/2+100,centerX()+width()/2,centerY()+height()/2+100, paint);

        paint.setColor(color.getColor(R.color.light_brown));

        canvas.drawCircle(centerX(), centerY()+height()/2, width()/2, paint);
        //start (unchanging) is (x,y) -> (centerX(), centerY()+height()/2)

        //end changes, is height length
        // first line is startX-height()*cos(tilt), startY-height*sin(tilt)
        //

        // top sling
        //canvas.drawRect(centerX()-width()/2, centerY()-height()/2,centerX()+width()/2,centerY()+height()/2, paint);
        canvas.drawCircle((float) (centerX()-height()*cos(tilt)), (float) (centerY()+height()/2-height()*sin(tilt)), width()/2, paint);
        paint.setStrokeWidth(width());
        canvas.drawLine(centerX(), centerY()+height()/2, (float) (centerX()-height()*cos(tilt)), (float) (centerY()+height()/2-height()*sin(tilt)), paint);
        paint.setStrokeWidth(width()+5);
        paint.setColor(color.getColor(R.color.red));
        canvas.drawLine((float) (centerX()-2*height()/3*cos(tilt)), (float) (centerY()+height()/2-2*height()/3*sin(tilt)), (float) (centerX()-height()*cos(tilt)), (float) (centerY()+height()/2-height()*sin(tilt)), paint);

        slingx = ((float) (centerX()-2*height()/3*cos(tilt))+(float) (centerX()-height()*cos(tilt)))/2;
        slingy = ((float) (centerY()+height()/2-2*height()/3*sin(tilt))+(float) (centerY()+height()/2-height()*sin(tilt)))/2;
        if (pullx!=-1f) {
            paint.setStrokeWidth(width() - 5);
            canvas.drawLine(slingx, slingy, pullx, pully, paint);
        }


    }

}
