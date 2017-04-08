package com.brett.exerciseplan.commons;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.brett.exerciseplan.ExercisePlanApplication;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by brett on 2017-04-07.
 */

public class BaseActivity extends AppCompatActivity{
    private Unbinder unbinder;

    protected ExercisePlanApplication application;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void bindButterKnife(Activity activity) {
        unbinder = ButterKnife.bind(activity);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
