package org.zzy.mealmenu.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

import org.zzy.mealmenu.moudle.application.MyApplication;


/**
 * Created by zhaoziying on 2017/5/3.
 */

public class MyRecyclerView extends RecyclerView {
    private final int MIN_KEY_INTERVAL = 300;
    private int lastKeyCode = 0;
    private long lastKeyTime = 0; //判断两次按键之间间隔是否小于100ms

    /****************************************************************************************************/

    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public boolean isKeyTooFast() {
        long now = System.currentTimeMillis();
        if (now - lastKeyTime > MIN_KEY_INTERVAL) {
            lastKeyTime = now;
            return false;
        } else {
            return true;
        }
    }
}
