package com.brett.exerciseplan.screens.login;

import com.brett.exerciseplan.commons.BasePresenter;

/**
 * Created by brett on 2017-04-07.
 */

public class LoginPresenter implements BasePresenter<LoginView> {
    private LoginView loginView;

    @Override
    public void attachView(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void detachView() {

    }
}
