package com.brett.exerciseplan.screens.main;

import com.brett.exerciseplan.commons.BasePresenter;

/**
 * Created by brett on 2017-04-07.
 */

public class MainPresenter implements BasePresenter<MainView> {
    private static final String TAG = MainPresenter.class.getSimpleName();

    private MainView mainView;

    @Override
    public void attachView(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void detachView() {
        mainView = null;
    }
}
