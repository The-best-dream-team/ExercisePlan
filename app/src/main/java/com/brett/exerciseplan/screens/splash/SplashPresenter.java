package com.brett.exerciseplan.screens.splash;

import com.brett.exerciseplan.commons.BasePresenter;

/**
 * Created by brett on 2017-04-07.
 */

public class SplashPresenter implements BasePresenter<SplashView> {
    SplashView splashView;
    @Override
    public void attachView(SplashView splashView) {
        this.splashView = splashView;
    }

    @Override
    public void detachView() {
        this.splashView = splashView;
    }
}
