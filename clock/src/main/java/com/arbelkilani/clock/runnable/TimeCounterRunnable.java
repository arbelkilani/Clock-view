package com.arbelkilani.clock.runnable;

import android.view.View;

public class TimeCounterRunnable implements Runnable {

    private View mView;

    public TimeCounterRunnable(View view) {
        mView = view;
    }

    @Override
    public void run() {
        mView.invalidate();
        mView.postDelayed(this, 1000);
    }
}
