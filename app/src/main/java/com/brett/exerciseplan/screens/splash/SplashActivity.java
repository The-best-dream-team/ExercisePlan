package com.brett.exerciseplan.screens.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.brett.exerciseplan.R;
import com.brett.exerciseplan.commons.BaseActivity;
import com.brett.exerciseplan.screens.login.LoginActivity;
import com.brett.exerciseplan.screens.main.MainActivity;

public class SplashActivity extends BaseActivity implements SplashView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bindButterKnife(this);

        // TODO : Login 여부에 따라 분기점 생성하여 동작하도록 수정 할것
        // new Handler().postDelayed(()->moveToMain(), 1000);
        new Handler().postDelayed(()->moveToLogin(), 1000);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void moveToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void moveToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
