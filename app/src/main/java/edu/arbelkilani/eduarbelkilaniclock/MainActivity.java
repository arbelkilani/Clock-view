package edu.arbelkilani.eduarbelkilaniclock;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;

    private ClockFragment clockFragment;
    private StopwatchFragment stopwatchFragment;
    private TimeCounterFragment timeCounterFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clockFragment = new ClockFragment();
        stopwatchFragment = new StopwatchFragment();
        timeCounterFragment = new TimeCounterFragment();

        loadFragment(clockFragment);
        toolbar = getSupportActionBar();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.clock:
                        loadFragment(clockFragment);
                        toolbar.setTitle(R.string.clock);
                        return true;

                    case R.id.stopwatch:
                        loadFragment(stopwatchFragment);
                        toolbar.setTitle(R.string.stopwatch);
                        return true;

                    case R.id.time_counter:
                        loadFragment(timeCounterFragment);
                        toolbar.setTitle(R.string.time_counter);
                        return true;
                }

                return false;
            }
        });

        toolbar.setTitle(R.string.clock);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();
    }

}
