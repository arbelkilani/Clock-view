package com.arbelkilani.clock.model;

import com.arbelkilani.clock.enumeration.numeric.ClockNumericFormat;

public class NumericTheme {

    private ClockNumericFormat clockNumericFormat;
    private int numericNumbersColor;
    private boolean numericShowSeconds;

    public ClockNumericFormat getClockNumericFormat() {
        return clockNumericFormat;
    }

    public int getNumericNumbersColor() {
        return numericNumbersColor;
    }

    public boolean isNumericShowSeconds() {
        return numericShowSeconds;
    }

    private NumericTheme(NumericThemeBuilder numericThemeBuilder) {
        this.clockNumericFormat = numericThemeBuilder.clockNumericFormat;
        this.numericNumbersColor = numericThemeBuilder.numericNumbersColor;
        this.numericShowSeconds = numericThemeBuilder.numericShowSeconds;
    }

    public static class NumericThemeBuilder {

        private ClockNumericFormat clockNumericFormat;
        private int numericNumbersColor;
        private boolean numericShowSeconds;

        public NumericThemeBuilder format(ClockNumericFormat clockNumericFormat) {
            this.clockNumericFormat = clockNumericFormat;
            return this;
        }

        public NumericThemeBuilder setNumbersColor(int numericNumbersColor) {
            this.numericNumbersColor = numericNumbersColor;
            return this;
        }

        public NumericThemeBuilder showSeconds(boolean showSeconds) {
            this.numericShowSeconds = showSeconds;
            return this;
        }

        public NumericTheme build() {
            return new NumericTheme(this);
        }
    }
}
