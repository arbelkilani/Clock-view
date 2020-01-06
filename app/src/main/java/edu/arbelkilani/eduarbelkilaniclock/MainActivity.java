package edu.arbelkilani.eduarbelkilaniclock;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.arbelkilani.clock.Clock;
import com.arbelkilani.clock.enumeration.ClockDegreeStep;
import com.arbelkilani.clock.enumeration.ClockType;
import com.arbelkilani.clock.enumeration.ClockValueDisposition;
import com.arbelkilani.clock.enumeration.ClockValueStep;
import com.arbelkilani.clock.listener.ClockListener;
import com.arbelkilani.clock.model.ClockTheme;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Clock clock = findViewById(R.id.clock);
        clock.setStyle(ClockType.analogical);
    }

}
