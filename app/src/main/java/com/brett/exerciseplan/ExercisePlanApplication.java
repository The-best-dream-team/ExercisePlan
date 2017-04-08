package com.brett.exerciseplan;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Brett on 2017-04-07.
 */

public class ExercisePlanApplication extends Application {
    @Getter @Setter
    private static Context context;

    @Getter @Setter
    private static volatile Activity currentActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        ExercisePlanApplication.context = this;
    }
}
