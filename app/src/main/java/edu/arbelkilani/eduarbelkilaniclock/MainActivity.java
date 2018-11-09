package edu.arbelkilani.eduarbelkilaniclock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.arbelkilani.clock.Clock;
import com.arbelkilani.clock.enumeration.ClockDegreeStep;
import com.arbelkilani.clock.enumeration.ClockValueDisposition;
import com.arbelkilani.clock.enumeration.ClockValueStep;
import com.arbelkilani.clock.enumeration.ClockValueType;
import com.arbelkilani.clock.model.ClockTheme;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Clock clock3 = findViewById(R.id.clock_3);
        clock3.setShowDegrees(true);
        clock3.setClockDegreeStep(ClockDegreeStep.full);
        clock3.setShowHoursValues(true);
        clock3.setClockValueStep(ClockValueStep.full);
        clock3.setClockValueDisposition(ClockValueDisposition.alternate);

        Clock clock4 = findViewById(R.id.clock_4);
        clock4.setShowBorder(true);
        clock4.setBorderColor(R.color.gray);
        clock4.setShowHoursProgress(true);
        clock4.setHoursProgressColor(R.color.black);
        clock4.setShowHoursValues(true);
        clock4.setClockValueStep(ClockValueStep.quarter);
        clock4.setShowCenter(true);
        clock4.setCenterOuterColor(R.color.black);
        clock4.setCenterInnerColor(R.color.gray);

        Clock clock5 = findViewById(R.id.clock_5);
        ClockTheme clockTheme = new ClockTheme.ClockThemeBuilder()
                .showBorder(true, R.color.gray)
                .showHoursProgress(true, R.color.black)
                .showMinutesProgress(true, R.color.black, 0.35f)
                .showMinutesValues(true, 0.37f)
                .showHoursValues(true, ClockValueStep.quarter)
                .build();
        clock5.setTheme(clockTheme);

    }

}
