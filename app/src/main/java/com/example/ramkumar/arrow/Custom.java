package com.example.ramkumar.arrow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class Custom extends View {


    Context mContext;
    private int centerX;
    private int centerY;
    private int radius;
    private double arrLength;
    private double arrHeading;
    private int margin = 10;
    public static enum Direction{
        Top,
        Bottom,
        Right,
        Left
    };
    public Direction direction;

    public Custom(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //Paint Background
        Paint background = new Paint();
        background.setColor(Color.TRANSPARENT);
        canvas.drawRect(0, 0, getWidth(), getHeight(), background);
        Paint paint = new Paint();
        Path path = new Path();
        paint.setStrokeWidth(10);
        paint.setColor(Color.WHITE);
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
        arrLength = radius - 10;

        if(centerX < centerY)
            radius = centerX - margin;
        else
            radius = centerY - margin;

        switch (direction){
            case Bottom:
                canvas.drawLine(centerX, 0,centerX, getHeight(), paint);
                paint = new Paint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(10);
                paint.setColor(Color.WHITE);

                path.moveTo(centerX, 0);
                path.lineTo(centerX-30, 40);
                path.moveTo(centerX, 0);
                path.lineTo(centerX+30, 40);
                canvas.drawPath(path, paint);
                break;
            case Top:
                canvas.drawLine(centerX, 0,centerX, getHeight(), paint);

                //Draw ArrowHead
                //This is where I'm confused
                paint = new Paint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(10);
                paint.setColor(Color.WHITE);

                path.moveTo(centerX, 0);
                path.lineTo(centerX-30, -40);
                path.moveTo(centerX, 0);
                path.lineTo(centerX-30, +40);
                canvas.drawPath(path, paint);
                break;
            case Left:
                //Draw Shaft
                //int[] xy = findArrowPos(arrLength, arrHeading);
                canvas.drawLine(0, centerY,getWidth(), centerY, paint);

                //Draw ArrowHead
                //This is where I'm confused
                paint = new Paint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(10);
                paint.setColor(Color.WHITE);

                path.moveTo(getWidth(), centerY);
                path.lineTo(getWidth()-40, centerY-30);
                path.moveTo(getWidth(), centerY);
                path.lineTo(getWidth()-40, centerY+30);
                canvas.drawPath(path, paint);
                break;
            case Right:
                //Draw Shaft
                //int[] xy = findArrowPos(arrLength, arrHeading);
                canvas.drawLine(0, centerY,getWidth(), centerY, paint);

                //Draw ArrowHead
                //This is where I'm confused
                paint = new Paint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(10);
                paint.setColor(Color.WHITE);
                path = new Path();
                path.moveTo(0, centerY);
                path.lineTo(40, centerY-30);
                path.moveTo(0, centerY);
                path.lineTo(40, centerY+30);
                canvas.drawPath(path, paint);
                break;

        }
        //Set vars for Arrow Paint

    }



//    private int[] findArrowPos(double length, double angle) {
//        int[] points = new int[2];
//        double theta = Math.toRadians(angle);
//        points[0] = centerX + (int) (length * Math.cos(theta));
//        points[1] = centerY + (int) (length * Math.sin(theta));
//        return points;
//    }
}
