package com.jaggadavid.angrybirds;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class GameActivity extends View {


    public GameActivity(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Sling sling = new Sling(100,100,100,100);
        sling.draw(canvas, getResources().getColor(R.color.brown));
    }
}
