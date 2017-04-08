package com.brett.exerciseplan.screens.main.home;

import com.brett.exerciseplan.commons.BasePresenter;

/**
 * Created by brett on 2017-04-07.
 */

public class HomePresenter implements BasePresenter<HomeView> {
    private HomeView homeView;

    @Override
    public void attachView(HomeView homeView) {
        this.homeView = homeView;
    }

    @Override
    public void detachView() {

    }
}
