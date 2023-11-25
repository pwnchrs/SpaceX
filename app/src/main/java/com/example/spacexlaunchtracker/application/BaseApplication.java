package com.example.spacexlaunchtracker.application;

import android.app.Application;

public class BaseApplication extends Application {
    private static BaseApplication mInstance;

    public static BaseApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        mInstance = null;
    }
}
