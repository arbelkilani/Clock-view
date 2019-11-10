package com.arbelkilani.clock.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.arbelkilani.clock.enumeration.ClockDegreeStep;
import com.arbelkilani.clock.enumeration.ClockDegreeType;
import com.arbelkilani.clock.enumeration.ClockValueDisposition;
import com.arbelkilani.clock.enumeration.ClockValueStep;
import com.arbelkilani.clock.enumeration.ClockValueType;

public class ClockTheme {

    private final static float MIN_SECONDS_PROGRESS_FACTOR = 0.2f;
    private final static float DEFAULT_PROGRESS_FACTOR = 0.4f;
    private final static float DEFAULT_SECONDS_PROGRESS_FACTOR = 0.7f;
    private final static float MAX_SECONDS_PROGRESS_FACTOR = 0.9f;

    private final static float MAX_MINUTES_VALUES_FACTOR = 0.5f;
    private final static float MIN_MINUTES_VALUES_FACTOR = 0.2f;

    private boolean showCenter;
    private int centerInnerColor;
    private int centerOuterColor;

    private boolean showBorder;
    private int borderColor;
    private boolean showHoursProgress;
    private int hoursProgressColor;
    private boolean showMinutesProgress;
    private int minutesProgressColor;
    private float minutesProgressFactor;
    private boolean showSecondsProgress;
    private int secondsProgressColor;
    private float secondsProgressFactor;

    private boolean showSecondsNeedle;
    private int secondsNeedleColor;
    private int hoursNeedleColor;
    private int minutesNeedleColor;

    private boolean showDegrees;
    private int degreesColor;
    private ClockDegreeType clockDegreeType;
    private ClockDegreeStep clockDegreeStep;
    private ClockValueStep clockValueStep;

    private boolean showHoursValues;
    private int hoursValuesColor;
    private int hoursValuesFont;
    private ClockValueType clockValueType;
    private ClockValueDisposition clockValueDisposition;

    private boolean showMinutesValues;
    private float minutesValuesFactor;

    private int clockBackground;

    public boolean isShowCenter() {
        return showCenter;
    }

    public int getCenterInnerColor() {
        return centerInnerColor;
    }

    public int getCenterOuterColor() {
        return centerOuterColor;
    }

    public boolean isShowBorder() {
        return showBorder;
    }

    public int getBorderColor() {
        return borderColor;
    }

    public boolean isShowHoursProgress() {
        return showHoursProgress;
    }

    public int getHoursProgressColor() {
        return hoursProgressColor;
    }

    public boolean isShowMinutesProgress() {
        return showMinutesProgress;
    }


    public boolean isShowHoursValues() {
        return showHoursValues;
    }

    public int getMinutesProgressColor() {
        return minutesProgressColor;
    }

    public float getMinutesProgressFactor() {
        return minutesProgressFactor;
    }

    public boolean isShowMinutesValues() {
        return showMinutesValues;
    }

    public float getMinutesValuesFactor() {
        return minutesValuesFactor;
    }

    public boolean isShowDegrees() {
        return showDegrees;
    }

    public ClockDegreeType getClockDegreeType() {
        return clockDegreeType;
    }

    public boolean isShowSecondsNeedle() {
        return showSecondsNeedle;
    }

    public boolean isShowSecondsProgress() {
        return showSecondsProgress;
    }

    public int getSecondsProgressColor() {
        return secondsProgressColor;
    }

    public float getSecondsProgressFactor() {
        return secondsProgressFactor;
    }


    public int getSecondsNeedleColor() {
        return secondsNeedleColor;
    }

    public int getHoursNeedleColor() {
        return hoursNeedleColor;
    }

    public int getMinutesNeedleColor() {
        return minutesNeedleColor;
    }

    public int getDegreesColor() {
        return degreesColor;
    }

    public int getHoursValuesColor() {
        return hoursValuesColor;
    }

    public int getHoursValuesFont() {
        return hoursValuesFont;
    }

    public ClockValueType getClockValueType() {
        return clockValueType;
    }

    public ClockValueDisposition getClockValueDisposition() {
        return clockValueDisposition;
    }

    public ClockValueStep getClockValueStep() {
        return clockValueStep;
    }

    public int getClockBackground() {
        return clockBackground;
    }

    public ClockDegreeStep getClockDegreeStep() {
        return clockDegreeStep;
    }

    private ClockTheme(ClockThemeBuilder clockThemeBuilder) {

        this.showCenter = clockThemeBuilder.showCenter;
        this.centerInnerColor = clockThemeBuilder.centerInnerColor;
        this.centerOuterColor = clockThemeBuilder.centerOuterColor;

        this.showBorder = clockThemeBuilder.showBorder;
        this.borderColor = clockThemeBuilder.borderColor;
        this.showHoursProgress = clockThemeBuilder.showHoursProgress;
        this.hoursProgressColor = clockThemeBuilder.hoursProgressColor;
        this.showMinutesProgress = clockThemeBuilder.showMinutesProgress;
        this.minutesProgressColor = clockThemeBuilder.minutesProgressColor;
        this.minutesProgressFactor = clockThemeBuilder.minutesProgressFactor;
        this.showSecondsProgress = clockThemeBuilder.showSecondsProgress;
        this.secondsProgressColor = clockThemeBuilder.secondsProgressColor;
        this.secondsProgressFactor = clockThemeBuilder.secondsProgressFactor;

        this.showSecondsNeedle = clockThemeBuilder.showSecondsNeedle;
        this.secondsNeedleColor = clockThemeBuilder.secondsNeedleColor;
        this.hoursNeedleColor = clockThemeBuilder.hoursNeedleColor;
        this.minutesNeedleColor = clockThemeBuilder.minutesNeedleColor;

        this.showDegrees = clockThemeBuilder.showDegrees;
        this.degreesColor = clockThemeBuilder.degreesColor;
        this.clockDegreeType = clockThemeBuilder.clockDegreeType;
        this.clockDegreeStep = clockThemeBuilder.clockDegreeStep;

        this.showHoursValues = clockThemeBuilder.showHoursValues;
        this.hoursValuesColor = clockThemeBuilder.hoursValuesColor;
        this.hoursValuesFont = clockThemeBuilder.hoursValuesFont;
        this.clockValueType = clockThemeBuilder.clockValueType;
        this.clockValueDisposition = clockThemeBuilder.clockValueDisposition;
        this.clockValueStep = clockThemeBuilder.clockValueStep;

        this.showMinutesValues = clockThemeBuilder.showMinutesValues;
        this.minutesValuesFactor = clockThemeBuilder.minutesValuesFactor;

        this.clockBackground = clockThemeBuilder.clockBackground;

    }

    public static class ClockThemeBuilder {

        private boolean showCenter;
        private int centerInnerColor;
        private int centerOuterColor;

        private boolean showBorder;
        private int borderColor;
        private boolean showHoursProgress;
        private int hoursProgressColor;
        private boolean showMinutesProgress;
        private int minutesProgressColor;
        private float minutesProgressFactor;
        private boolean showSecondsProgress;
        private int secondsProgressColor;
        private float secondsProgressFactor;

        private boolean showSecondsNeedle;
        private int secondsNeedleColor;
        private int hoursNeedleColor;
        private int minutesNeedleColor;

        private boolean showDegrees;
        private int degreesColor;
        private ClockDegreeType clockDegreeType;
        private ClockDegreeStep clockDegreeStep;

        private boolean showHoursValues;
        private int hoursValuesColor;
        private int hoursValuesFont;
        private ClockValueType clockValueType;
        private ClockValueDisposition clockValueDisposition;
        private ClockValueStep clockValueStep;

        private boolean showMinutesValues;
        private float minutesValuesFactor;

        private int clockBackground;

        public ClockThemeBuilder showCenter(boolean showCenter) {
            this.showCenter = showCenter;
            return this;
        }

        public ClockThemeBuilder showCenter(boolean showCenter, int innerColor, int outerColor) {
            this.showCenter = showCenter;
            this.centerInnerColor = innerColor;
            this.centerOuterColor = outerColor;
            return this;
        }

        public ClockThemeBuilder showBorder(boolean showBorder) {
            this.showBorder = showBorder;
            return this;
        }

        public ClockThemeBuilder showBorder(boolean showBorder, int borderColor) {
            this.showBorder = showBorder;
            this.borderColor = borderColor;
            return this;
        }

        public ClockThemeBuilder showHoursProgress(boolean showHoursProgress) {
            this.showHoursProgress = showHoursProgress;
            return this;
        }

        public ClockThemeBuilder showHoursProgress(boolean showHoursProgress, int hoursProgressColor) {
            this.showHoursProgress = showHoursProgress;
            this.hoursProgressColor = hoursProgressColor;
            return this;
        }

        public ClockThemeBuilder showMinutesProgress(boolean showMinutesProgress) {
            this.showMinutesProgress = showMinutesProgress;
            this.minutesProgressFactor = DEFAULT_PROGRESS_FACTOR;
            return this;
        }

        public ClockThemeBuilder showMinutesProgress(boolean showMinutesProgress, int minutesProgressColor) {
            this.showMinutesProgress = showMinutesProgress;
            this.minutesProgressFactor = DEFAULT_PROGRESS_FACTOR;
            this.minutesProgressColor = minutesProgressColor;
            return this;
        }

        public ClockThemeBuilder showMinutesProgress(boolean showMinutesProgress, float minutesProgressFactor) {
            this.showMinutesProgress = showMinutesProgress;
            if (showMinutesProgress) {
                if (MIN_SECONDS_PROGRESS_FACTOR <= minutesProgressFactor && minutesProgressFactor <= MAX_SECONDS_PROGRESS_FACTOR) {
                    this.minutesProgressFactor = minutesProgressFactor;
                } else {
                    throw new IllegalArgumentException("Factor should be between " + MIN_SECONDS_PROGRESS_FACTOR + " and " + MAX_SECONDS_PROGRESS_FACTOR + " ==> set : " + minutesProgressFactor);
                }
            }
            return this;
        }

        public ClockThemeBuilder showMinutesProgress(boolean showMinutesProgress, int minutesProgressColor, float minutesProgressFactor) {
            this.showMinutesProgress = showMinutesProgress;
            this.minutesProgressColor = minutesProgressColor;
            if (showMinutesProgress) {
                if (MIN_SECONDS_PROGRESS_FACTOR <= minutesProgressFactor && minutesProgressFactor <= MAX_SECONDS_PROGRESS_FACTOR) {
                    this.minutesProgressFactor = minutesProgressFactor;
                } else {
                    throw new IllegalArgumentException("Factor should be between " + MIN_SECONDS_PROGRESS_FACTOR + " and " + MAX_SECONDS_PROGRESS_FACTOR + " ==> set : " + minutesProgressFactor);
                }
            }
            return this;
        }

        public ClockThemeBuilder showSecondsProgress(boolean showSecondsProgress) {
            this.showSecondsProgress = showSecondsProgress;
            this.secondsProgressFactor = DEFAULT_SECONDS_PROGRESS_FACTOR;
            return this;
        }

        public ClockThemeBuilder showSecondsProgress(boolean showSecondsProgress, int secondsProgressColor) {
            this.showSecondsProgress = showSecondsProgress;
            this.secondsProgressFactor = DEFAULT_SECONDS_PROGRESS_FACTOR;
            this.secondsProgressColor = secondsProgressColor;
            return this;
        }

        public ClockThemeBuilder showSecondsProgress(boolean showSecondsProgress, float secondsProgressFactor) {
            this.showSecondsProgress = showSecondsProgress;
            this.secondsProgressFactor = secondsProgressFactor;
            return this;
        }

        public ClockThemeBuilder showSecondsProgress(boolean showSecondsProgress, int secondsProgressColor, float secondsProgressFactor) {
            this.showSecondsProgress = showSecondsProgress;
            this.secondsProgressColor = secondsProgressColor;
            if (showSecondsProgress) {
                if (MIN_SECONDS_PROGRESS_FACTOR <= secondsProgressFactor && secondsProgressFactor <= MAX_SECONDS_PROGRESS_FACTOR) {
                    this.secondsProgressFactor = secondsProgressFactor;
                } else {
                    throw new IllegalArgumentException("Factor should be between " + MIN_SECONDS_PROGRESS_FACTOR + " and " + MAX_SECONDS_PROGRESS_FACTOR + " ==> set : " + secondsProgressFactor);
                }
            }
            return this;
        }

        public ClockThemeBuilder showHoursValues(boolean showHoursValues) {
            this.showHoursValues = showHoursValues;
            this.clockValueType = ClockValueType.none;
            this.clockValueDisposition = ClockValueDisposition.regular;
            this.clockValueStep = ClockValueStep.full;
            return this;
        }

        public ClockThemeBuilder showHoursValues(boolean showHoursValues, ClockValueStep clockValueStep) {
            this.showHoursValues = showHoursValues;
            this.clockValueType = ClockValueType.none;
            this.clockValueDisposition = ClockValueDisposition.regular;
            this.clockValueStep = clockValueStep;
            return this;
        }

        public ClockThemeBuilder showHoursValues(boolean showHoursValues, ClockValueType clockValueType, ClockValueDisposition clockValueDisposition) {
            this.showHoursValues = showHoursValues;
            this.clockValueType = clockValueType;
            this.clockValueDisposition = clockValueDisposition;
            this.clockValueStep = ClockValueStep.full;
            return this;
        }

        public ClockThemeBuilder showHoursValues(boolean showHoursValues, ClockValueType clockValueType, ClockValueStep clockValueStep) {
            this.showHoursValues = showHoursValues;
            this.clockValueType = clockValueType;
            this.clockValueDisposition = ClockValueDisposition.alternate;
            this.clockValueStep = clockValueStep;
            return this;
        }

        public ClockThemeBuilder showHoursValues(boolean showHoursValues, int hoursValuesColor) {
            this.showHoursValues = showHoursValues;
            this.hoursValuesColor = hoursValuesColor;
            this.clockValueType = ClockValueType.none;
            this.clockValueDisposition = ClockValueDisposition.regular;
            this.clockValueStep = ClockValueStep.full;
            return this;
        }

        public ClockThemeBuilder showHoursValues(boolean showHoursValues, ClockValueType clockValueType) {
            this.showHoursValues = showHoursValues;
            this.clockValueType = clockValueType;
            this.clockValueDisposition = ClockValueDisposition.regular;
            this.clockValueStep = ClockValueStep.full;
            return this;
        }

        public ClockThemeBuilder showHoursValues(boolean showHoursValues, ClockValueDisposition clockValueDisposition) {
            this.showHoursValues = showHoursValues;
            this.clockValueDisposition = clockValueDisposition;
            this.clockValueType = ClockValueType.none;
            this.clockValueStep = ClockValueStep.full;
            return this;
        }

        public ClockThemeBuilder showHoursValues(boolean showHoursValues, int hoursValuesColor, int hoursValuesFont, ClockValueType clockValueType) {
            this.showHoursValues = showHoursValues;
            this.hoursValuesColor = hoursValuesColor;
            this.hoursValuesFont = hoursValuesFont;
            this.clockValueType = clockValueType;
            this.clockValueDisposition = ClockValueDisposition.regular;
            this.clockValueStep = ClockValueStep.full;
            return this;
        }

        public ClockThemeBuilder showHoursValues(boolean showHoursValues, int hoursValuesColor, int hoursValuesFont, ClockValueStep clockValueStep) {
            this.showHoursValues = showHoursValues;
            this.hoursValuesColor = hoursValuesColor;
            this.hoursValuesFont = hoursValuesFont;
            this.clockValueType = ClockValueType.none;
            this.clockValueDisposition = ClockValueDisposition.regular;
            this.clockValueStep = clockValueStep;
            return this;
        }

        public ClockThemeBuilder showHoursValues(boolean showHoursValues, int hoursValuesColor, int hoursValuesFont, ClockValueType clockValueType, ClockValueDisposition clockValueDisposition, ClockValueStep clockValueStep) {
            this.showHoursValues = showHoursValues;
            this.hoursValuesColor = hoursValuesColor;
            this.hoursValuesFont = hoursValuesFont;
            this.clockValueType = clockValueType;
            this.clockValueDisposition = clockValueDisposition;
            this.clockValueStep = clockValueStep;
            return this;
        }

        public ClockThemeBuilder showMinutesValues(boolean showMinutesValues, float minutesValuesFactor) {
            this.showMinutesValues = showMinutesValues;
            if (showMinutesValues) {
                if (MIN_MINUTES_VALUES_FACTOR <= minutesValuesFactor && minutesValuesFactor <= MAX_MINUTES_VALUES_FACTOR) {
                    this.minutesValuesFactor = minutesValuesFactor;
                } else {
                    throw new IllegalArgumentException("Factor should be between " + MIN_MINUTES_VALUES_FACTOR + " and " + MAX_MINUTES_VALUES_FACTOR + " ==> set : " + minutesValuesFactor);
                }
            }
            this.clockValueType = ClockValueType.none;
            return this;
        }

        public ClockThemeBuilder showDegrees(boolean showDegrees, int degreesColor, @NonNull ClockDegreeType clockDegreeType, @NonNull ClockDegreeStep clockDegreeStep) {
            this.showDegrees = showDegrees;
            this.degreesColor = degreesColor;
            this.clockDegreeType = clockDegreeType;
            this.clockDegreeStep = clockDegreeStep;
            return this;
        }

        public ClockThemeBuilder showDegrees(boolean showDegrees, @Nullable ClockDegreeType clockDegreeType) {
            this.showDegrees = showDegrees;
            this.clockDegreeType = clockDegreeType;
            this.clockDegreeStep = ClockDegreeStep.full;
            return this;
        }

        public ClockThemeBuilder showDegrees(boolean showDegrees, int degreesColor) {
            this.showDegrees = showDegrees;
            this.degreesColor = degreesColor;
            this.clockDegreeType = ClockDegreeType.line;
            this.clockDegreeStep = ClockDegreeStep.full;
            return this;
        }

        public ClockThemeBuilder showDegrees(boolean showDegrees, int degreesColor, ClockDegreeStep clockDegreeStep) {
            this.showDegrees = showDegrees;
            this.degreesColor = degreesColor;
            this.clockDegreeType = ClockDegreeType.line;
            this.clockDegreeStep = clockDegreeStep;
            return this;
        }

        public ClockThemeBuilder showDegrees(boolean showDegrees, int degreesColor, ClockDegreeType clockDegreeType) {
            this.showDegrees = showDegrees;
            this.degreesColor = degreesColor;
            this.clockDegreeType = clockDegreeType;
            this.clockDegreeStep = ClockDegreeStep.full;
            return this;
        }

        public ClockThemeBuilder showDegrees(boolean showDegrees, ClockDegreeStep clockDegreeStep) {
            this.showDegrees = showDegrees;
            this.clockDegreeType = ClockDegreeType.line;
            this.clockDegreeStep = clockDegreeStep;
            return this;
        }

        public ClockThemeBuilder showDegrees(boolean showDegrees) {
            this.showDegrees = showDegrees;
            this.clockDegreeType = ClockDegreeType.line;
            this.clockDegreeStep = ClockDegreeStep.full;
            return this;
        }

        public ClockThemeBuilder showSecondsNeedle(boolean showSecondsNeedle) {
            this.showSecondsNeedle = showSecondsNeedle;
            return this;
        }

        public ClockThemeBuilder showSecondsNeedle(boolean showSecondsNeedle, int secondsNeedleColor) {
            this.showSecondsNeedle = showSecondsNeedle;
            this.secondsNeedleColor = secondsNeedleColor;
            return this;
        }

        public ClockThemeBuilder setHoursNeedleColor(int hoursNeedleColor) {
            this.hoursNeedleColor = hoursNeedleColor;
            return this;
        }

        public ClockThemeBuilder setMinutesNeedleColor(int minutesNeedleColor) {
            this.minutesNeedleColor = minutesNeedleColor;
            return this;
        }

        public ClockThemeBuilder setClockBackground(int clockBackground) {
            this.clockBackground = clockBackground;
            return this;
        }

        public ClockTheme build() {
            return new ClockTheme(this);
        }
    }

}
