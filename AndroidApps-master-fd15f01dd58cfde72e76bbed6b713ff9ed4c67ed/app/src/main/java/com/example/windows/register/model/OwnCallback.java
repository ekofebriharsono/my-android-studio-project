package com.example.windows.register.model;

/**
 * Created by m-hasan on 25/07/17.
 */

public abstract class OwnCallback {
    public void onSuccess(String message){}
    public void onError(String errorCode, String message){}
}
