package com.brett.exerciseplan.screens.main.videos;

import com.brett.exerciseplan.commons.BasePresenter;

/**
 * Created by brett on 2017-04-07.
 */

public class VideoPresenter implements BasePresenter<VideoView> {
    private VideoView videoView;

    @Override
    public void attachView(VideoView videoView) {
        this.videoView = videoView;
    }

    @Override
    public void detachView() {

    }
}
