package com.example.ramkumar.arrow;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout CL;
    Button one,two;
    TextView tv;
    RelativeLayout rl;
    FrameLayout frame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CL= findViewById(R.id.mainLayout);
        tv = findViewById(R.id.textView3);
        one = findViewById(R.id.button);
        two = findViewById(R.id.button2);
        frame = findViewById(R.id.frame);


//        rl = new RelativeLayout(this);
//        LinearLayout.LayoutParams paramRl = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
//        rl.setLayoutParams(paramRl);
//        rl.setBackgroundColor(Color.parseColor("#A0000000"));
//        frame.addView(rl);



    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void onWindowFocusChanged (boolean hasFocus) {
        final int[] x=new int[2];
        int[] rect1 = new int[2];
        tv.getLocationInWindow(rect1);
        int[] rect2 = new int[2];
        tv.getLocationOnScreen(rect2);
        int height = tv.getHeight();
        int height1= tv.getMeasuredHeight();
        int width = tv.getWidth();
        int width1 = tv.getMeasuredWidth();

        View ButtonView = new View(this);
        LinearLayout.LayoutParams paramRl = new LinearLayout.LayoutParams(width,height);
        paramRl.leftMargin = rect1[0];
        paramRl.topMargin = rect1[1]-240;
        ButtonView.setLayoutParams(paramRl);
        ButtonView.setBackgroundResource(R.drawable.border);
        frame.addView(ButtonView);


        Custom view = new Custom(this);
        view.direction = Custom.Direction.Bottom;
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(100,200);
        param.leftMargin = rect1[0]+width/2-50;
        param.topMargin = rect1[1]-240+height+5;
        view.setBackgroundColor(Color.TRANSPARENT);
        view.setLayoutParams(param);
        frame.addView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
