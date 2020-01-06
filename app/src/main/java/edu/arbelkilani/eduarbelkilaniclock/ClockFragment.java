package edu.arbelkilani.eduarbelkilaniclock;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arbelkilani.clock.Clock;
import com.arbelkilani.clock.enumeration.ClockType;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClockFragment extends Fragment {

    public ClockFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clock, container, false);
        return view;
    }
}
