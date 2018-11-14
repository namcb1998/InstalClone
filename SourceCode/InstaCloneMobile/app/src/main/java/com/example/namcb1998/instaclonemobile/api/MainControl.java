package com.example.namcb1998.instaclonemobile.api;

import android.app.Activity;

import okhttp3.MediaType;

public class MainControl {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private Activity activity;

    public MainControl(Activity activity) {
        this.activity = activity;
    }

    protected void runOnUiThread(Runnable runnable) {
        this.activity.runOnUiThread(runnable);
    }
}
