package com.arbelkilani.clock.listener;

import com.arbelkilani.clock.enumeration.TimeCounterState;

public interface TimeCounterListener {

    void onTimeCounterCompleted();

    void onTimeCounterStateChanged(TimeCounterState timeCounterState);

}
