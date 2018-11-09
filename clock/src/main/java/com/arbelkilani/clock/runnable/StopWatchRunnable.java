package com.arbelkilani.clock.runnable;

import android.view.View;

public class StopWatchRunnable implements Runnable {

    private View mView;

    public StopWatchRunnable(View view) {
        mView = view;
    }

    @Override
    public void run() {
        mView.invalidate();
        mView.postDelayed(this, 0);
    }
}
