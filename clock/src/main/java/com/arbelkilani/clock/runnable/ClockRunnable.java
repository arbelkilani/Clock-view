package com.arbelkilani.clock.runnable;

import android.view.View;

public class ClockRunnable implements Runnable {

    private static final long SECOND = 1000;
    private View mView;

    public ClockRunnable(View view) {
        mView = view;
    }

    @Override
    public void run() {
        mView.invalidate();
        mView.postDelayed(this, SECOND);
    }
}
