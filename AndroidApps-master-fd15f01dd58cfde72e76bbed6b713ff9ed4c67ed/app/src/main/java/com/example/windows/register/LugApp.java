package com.example.windows.register;

import android.app.Application;
import android.content.Context;

/**
 * Created by m-hasan on 25/07/17.
 */

public class LugApp extends Application {
    protected static LugApp mInstance;
    public static Context getContext() {
        return mInstance.getApplicationContext();
    }
    public static synchronized LugApp getInstance() {
        return mInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

}
