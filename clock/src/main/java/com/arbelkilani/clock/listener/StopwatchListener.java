package com.arbelkilani.clock.listener;

import com.arbelkilani.clock.enumeration.StopwatchState;
import com.arbelkilani.clock.model.StopwatchSavedItem;

public interface StopwatchListener {

    void onStopwatchStateChanged(StopwatchState stopwatchState);

    void onStopwatchSaveValue(StopwatchSavedItem stopwatchSavedItem);
}
