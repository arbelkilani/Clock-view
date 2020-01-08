package com.arbelkilani.clock.model.theme;

import com.arbelkilani.clock.enumeration.ClockType;

public class TimeCounterTheme {

    private ClockType clockType;

    private int clockBackground;

    private int valuesFont;
    private int valuesColor;

    private boolean showProgress;
    private int progressColor;
    private int borderColor;

    public ClockType getClockType() {
        return clockType;
    }

    public int getClockBackground() {
        return clockBackground;
    }

    public int getValuesFont() {
        return valuesFont;
    }

    public int getValuesColor() {
        return valuesColor;
    }

    public boolean isShowProgress() {
        return showProgress;
    }

    public int getProgressColor() {
        return progressColor;
    }

    public int getBorderColor() {
        return borderColor;
    }

    private TimeCounterTheme(TimeCounterThemeBuilder timeCounterThemeBuilder) {

        this.clockType = timeCounterThemeBuilder.clockType;

        this.clockBackground = timeCounterThemeBuilder.clockBackground;

        this.valuesFont = timeCounterThemeBuilder.valuesFont;
        this.valuesColor = timeCounterThemeBuilder.valuesColor;

        this.showProgress = timeCounterThemeBuilder.showProgress;
        this.progressColor = timeCounterThemeBuilder.progressColor;
        this.borderColor = timeCounterThemeBuilder.borderColor;
    }

    public static class TimeCounterThemeBuilder {

        private ClockType clockType;

        private int clockBackground;

        private int valuesFont;
        private int valuesColor;

        private boolean showProgress;
        private int progressColor;
        private int borderColor;

        public TimeCounterThemeBuilder setClockType(ClockType clockType) {
            this.clockType = clockType;
            return this;
        }

        public TimeCounterThemeBuilder setClockBackground(int clockBackground) {
            this.clockBackground = clockBackground;
            return this;
        }

        public TimeCounterThemeBuilder setValuesFont(int valuesFont) {
            this.valuesFont = valuesFont;
            return this;
        }

        public TimeCounterThemeBuilder setValuesColor(int valuesColor) {
            this.valuesColor = valuesColor;
            return this;
        }

        public TimeCounterThemeBuilder setShowProgress(boolean showProgress) {
            this.showProgress = showProgress;
            return this;
        }

        public TimeCounterThemeBuilder setProgressColor(int progressColor) {
            this.progressColor = progressColor;
            return this;
        }

        public TimeCounterThemeBuilder setBorderColor(int borderColor) {
            this.borderColor = borderColor;
            return this;
        }

        public TimeCounterTheme build() {
            return new TimeCounterTheme(this);
        }
    }
}
