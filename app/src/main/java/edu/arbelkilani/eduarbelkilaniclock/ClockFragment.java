package edu.arbelkilani.eduarbelkilaniclock;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arbelkilani.clock.Clock;
import com.arbelkilani.clock.enumeration.ClockType;
import com.arbelkilani.clock.enumeration.numeric.ClockNumericFormat;
import com.arbelkilani.clock.model.ClockTheme;
import com.arbelkilani.clock.model.NumericTheme;


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

        Clock clock = view.findViewById(R.id.clock);
        clock.setStyle(ClockType.numeric);
        //clock.setClockNumericFormat(ClockNumericFormat.hour_24);
        //clock.setClockNumericShowSeconds(false);
        //clock.setNumbersColor(R.color.colorPrimaryDark);

        NumericTheme numericTheme = new NumericTheme.NumericThemeBuilder()
                .format(ClockNumericFormat.hour_12)
                .setNumbersColor(R.color.orange)
                .showSeconds(true)
                .build();
        //clock.setNumericTheme(numericTheme);


        return view;
    }
}
