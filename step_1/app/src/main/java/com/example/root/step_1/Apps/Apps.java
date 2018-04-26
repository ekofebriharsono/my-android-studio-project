package com.example.root.step_1.Apps;

import android.app.Application;
import android.content.Context;

/**
 * Created by root on 11/12/17.
 */

public class Apps extends Application {
    protected static Apps mInstance;
    public static Context getContext() {
        return mInstance.getApplicationContext();
    }
    public static synchronized Apps getInstance()    {
        return mInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

}
