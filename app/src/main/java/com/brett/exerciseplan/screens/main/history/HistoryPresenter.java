package com.brett.exerciseplan.screens.main.history;

import com.brett.exerciseplan.commons.BasePresenter;

/**
 * Created by brett on 2017-04-07.
 */

public class HistoryPresenter implements BasePresenter<HistoryView> {
    private HistoryView historyView;

    @Override
    public void attachView(HistoryView historyView) {
        this.historyView = historyView;
    }

    @Override
    public void detachView() {

    }
}
