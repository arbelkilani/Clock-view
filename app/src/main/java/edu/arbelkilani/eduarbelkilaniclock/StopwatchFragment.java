package edu.arbelkilani.eduarbelkilaniclock;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arbelkilani.clock.Clock;
import com.arbelkilani.clock.enumeration.ClockType;
import com.arbelkilani.clock.enumeration.StopwatchState;
import com.arbelkilani.clock.listener.StopwatchListener;
import com.arbelkilani.clock.model.StopwatchSavedItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends Fragment implements View.OnClickListener, StopwatchListener {

    private final static String TAG = StopwatchFragment.class.getSimpleName();

    private Clock stopwatch;
    private Button startBtn, stopBtn, saveBtn;
    private RecyclerView recyclerView;
    private List<StopwatchSavedItem> savedItemList;

    public StopwatchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {

        stopwatch = view.findViewById(R.id.stopwatch);
        stopwatch.setStopwatchListener(this);

        savedItemList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, true);
        StopWatchAdapter stopWatchAdapter = new StopWatchAdapter(savedItemList);

        recyclerView = view.findViewById(R.id.rv_values);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(stopWatchAdapter);

        startBtn = view.findViewById(R.id.btn_start);
        startBtn.setOnClickListener(this);

        stopBtn = view.findViewById(R.id.btn_stop);
        stopBtn.setOnClickListener(this);

        saveBtn = view.findViewById(R.id.btn_save);
        saveBtn.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveState : " + outState.toString());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                stopwatch.saveStopwatch();
                break;

            case R.id.btn_start:
                startStopWatch();
                break;

            case R.id.btn_stop:
                stopStopWatch();
                break;
        }
    }

    private void stopStopWatch() {
        stopwatch.stopStopwatch();
        startBtn.setText(R.string.start);
    }

    private void startStopWatch() {
        switch (stopwatch.getStopwatchState()) {
            case stopped:
                stopwatch.runStopwatch();
                startBtn.setText(R.string.pause);
                break;

            case running:
                stopwatch.pauseStopwatch();
                startBtn.setText(R.string.resume);
                break;

            case paused:
                stopwatch.resumeStopWatch();
                startBtn.setText(R.string.pause);
                break;
        }
    }

    @Override
    public void onStopwatchStateChanged(StopwatchState stopwatchState) {
        switch (stopwatchState) {
            case paused:
                startBtn.setText(R.string.resume);
                break;
            case running:
                startBtn.setText(R.string.pause);
                break;
            case stopped:
                startBtn.setText(R.string.start);
                break;
        }
    }

    @Override
    public void onStopwatchSaveValue(StopwatchSavedItem stopwatchSavedItem) {
        savedItemList.add(stopwatchSavedItem);
        Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
    }
}
