package org.zzy.mealmenu.moudle.application;

import android.app.Application;
import android.content.Context;

import com.zhy.autolayout.config.AutoLayoutConifg;

import org.zzy.aframwork.util.LogcatHelper;
import org.zzy.mealmenu.R;
import org.zzy.mealmenu.exception.CrashHandler;
import org.zzy.mealmenu.exception.DefaultExceptionHandler;

/**
 * Created by admin on 16/12/6.
 */

public class MyApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(getApplicationContext()));
        CrashHandler ch = CrashHandler.getInstance();
        ch.init(context);

        LogcatHelper.getInstance(context, context.getResources().getResourceName(R.string.app_name)).start();

        AutoLayoutConifg.getInstance().useDeviceSize().init(context);

    }





}