package com.brett.exerciseplan.commons;

/**
 * Created by brett on 2017-04-07.
 */

public interface BasePresenter<V> {
    void attachView(V v);

    void detachView();
}
