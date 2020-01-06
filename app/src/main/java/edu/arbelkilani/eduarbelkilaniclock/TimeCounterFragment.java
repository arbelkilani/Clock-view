package edu.arbelkilani.eduarbelkilaniclock;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.arbelkilani.clock.Clock;
import com.arbelkilani.clock.enumeration.TimeCounterState;
import com.arbelkilani.clock.listener.TimeCounterListener;

import java.util.concurrent.TimeUnit;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimeCounterFragment extends Fragment implements View.OnClickListener, TimeCounterListener {

    private final static String TAG = TimeCounterFragment.class.getSimpleName();

    private Clock timeCounter;

    private Spinner hoursSpinner, minutesSpinner, secondsSpinner;
    Button startButton, stopButton;

    public TimeCounterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_time_counter, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        timeCounter = view.findViewById(R.id.timeCounter);
        timeCounter.setTimeCounterListener(this);

        hoursSpinner = view.findViewById(R.id.spinner_hours);
        minutesSpinner = view.findViewById(R.id.spinner_minutes);
        secondsSpinner = view.findViewById(R.id.spinner_seconds);

        startButton = view.findViewById(R.id.btn_start);
        startButton.setOnClickListener(this);

        stopButton = view.findViewById(R.id.btn_stop);
        stopButton.setOnClickListener(this);

    }


    private Long getValue() {
        String hours = hoursSpinner.getSelectedItem().toString();
        String minutes = minutesSpinner.getSelectedItem().toString();
        String seconds = secondsSpinner.getSelectedItem().toString();


        return TimeUnit.HOURS.toMillis(Long.parseLong(hours)) +
                TimeUnit.MINUTES.toMillis(Long.parseLong(minutes)) +
                TimeUnit.SECONDS.toMillis(Long.parseLong(seconds));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_start:
                switch (timeCounter.getTimeCounterState()) {
                    case running:
                        timeCounter.pauseTimeCounter();
                        break;

                    case paused:
                        timeCounter.resumeTimeCounter();
                        break;

                    case stopped:
                        timeCounter.runTimeCounter(getValue());
                        break;
                }
                break;

            case R.id.btn_stop:
                timeCounter.stopTimeCounter();
                break;
        }
    }

    @Override
    public void onTimeCounterCompleted() {
        Log.i(TAG, "Time counter completed");
        resetTimeCounter();
    }


    private void resetTimeCounter() {
        startButton.setText(R.string.start);
        minutesSpinner.setSelection(0, true);
        secondsSpinner.setSelection(0, true);
    }

    @Override
    public void onTimeCounterStateChanged(TimeCounterState timeCounterState) {
        switch (timeCounterState) {
            case running:
                startButton.setText(R.string.pause);
                break;

            case stopped:
                resetTimeCounter();
                break;

            case paused:
                startButton.setText(R.string.resume);
                break;
        }
    }
}
