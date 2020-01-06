package com.arbelkilani.clock.global;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import com.arbelkilani.clock.enumeration.StopwatchState;
import com.arbelkilani.clock.enumeration.TimeCounterState;

public class ClockViewSaveState extends View.BaseSavedState {

    // Stopwatch
    public int mSeconds;
    public int mMinutes;

    public long mStartTime;
    public long mTimeBuffer;
    public long mMillisecondsTime;

    public StopwatchState mStopwatchState;

    // Time counter
    public long mTimeCounterValue;
    public long mInitialTimeCounter;
    public TimeCounterState mTimeCounterState;
    public long mTimeCounterAt;

    public ClockViewSaveState(Parcelable superState) {
        super(superState);
    }

    public static final Creator<ClockViewSaveState> CREATOR = new Creator<ClockViewSaveState>() {
        @Override
        public ClockViewSaveState createFromParcel(Parcel source) {
            return new ClockViewSaveState(source);
        }

        @Override
        public ClockViewSaveState[] newArray(int size) {
            return new ClockViewSaveState[size];
        }
    };

    private ClockViewSaveState(Parcel source) {
        super(source);

        mSeconds = source.readInt();
        mMinutes = source.readInt();

        mStartTime = source.readLong();
        mTimeBuffer = source.readLong();
        mMillisecondsTime = source.readLong();

        mStopwatchState = StopwatchState.valueOf(source.readString());

        mTimeCounterValue = source.readLong();
        mInitialTimeCounter = source.readLong();
        mTimeCounterAt = source.readLong();
        mTimeCounterState = TimeCounterState.valueOf(source.readString());
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);

        out.writeInt(mSeconds);
        out.writeInt(mMinutes);

        out.writeLong(mStartTime);
        out.writeLong(mTimeBuffer);
        out.writeLong(mMillisecondsTime);

        out.writeString(mStopwatchState.name());

        out.writeLong(mTimeCounterValue);
        out.writeLong(mInitialTimeCounter);
        out.writeLong(mTimeCounterAt);
        out.writeString(mTimeCounterState.name());
    }
}
