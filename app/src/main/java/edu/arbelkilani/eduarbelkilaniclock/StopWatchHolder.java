package edu.arbelkilani.eduarbelkilaniclock;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arbelkilani.clock.model.StopwatchSavedItem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class StopWatchHolder extends RecyclerView.ViewHolder {

    private TextView valueTextView, dateTextView, timeTextView;

    public StopWatchHolder(@NonNull View itemView) {
        super(itemView);
        valueTextView = itemView.findViewById(R.id.value);
        dateTextView = itemView.findViewById(R.id.date);
        timeTextView = itemView.findViewById(R.id.time);
    }

    @SuppressLint("DefaultLocale")
    public void populate(StopwatchSavedItem stopwatchSavedItem) {
        valueTextView.setText(String.format("%02d:%02d Min", stopwatchSavedItem.getMinutes(), stopwatchSavedItem.getSeconds()));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, MMM d", Locale.ENGLISH);
        dateTextView.setText(simpleDateFormat.format(stopwatchSavedItem.getCalendar().getTime()));


        String time = String.format("%s:%s %s",
                String.format(Locale.getDefault(), "%02d", stopwatchSavedItem.getCalendar().get(Calendar.HOUR)),
                String.format(Locale.getDefault(), "%02d", stopwatchSavedItem.getCalendar().get(Calendar.MINUTE)),
                stopwatchSavedItem.getCalendar().get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM");
        timeTextView.setText(time);

    }
}
