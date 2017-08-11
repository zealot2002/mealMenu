package org.zzy.mealmenu.exception;

import android.content.Context;

/**
 * Created by zhaoziying on 2017/5/24.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    static CrashHandler INSTANCE;
    static Context context;
    /**
     * 获取CrashHandler实例
     */
    public static CrashHandler getInstance() {
        if (INSTANCE == null)
            INSTANCE = new CrashHandler();
        return INSTANCE;
    }

    public void init(Context appContext) {
        context = appContext;
        // 设置该类为线程默认UncatchException的处理器。
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**
     * 当UncaughtException发生时会回调该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        System.out.println("system wrong....ex ："+ex.toString());
        RestartAPPTool.restartAPP(context,1000);
    }


}