package com.arbelkilani.clock.model;

import com.arbelkilani.clock.enumeration.numeric.ClockNumericFormat;

public class NumericTheme {

    private ClockNumericFormat clockNumericFormat;
    private int numericNumbersColor;

    public ClockNumericFormat getClockNumericFormat() {
        return clockNumericFormat;
    }

    public int getNumericNumbersColor() {
        return numericNumbersColor;
    }

    private NumericTheme(NumericThemeBuilder numericThemeBuilder) {
        this.clockNumericFormat = numericThemeBuilder.clockNumericFormat;
        this.numericNumbersColor = numericThemeBuilder.numericNumbersColor;
    }

    public static class NumericThemeBuilder {

        private ClockNumericFormat clockNumericFormat;
        private int numericNumbersColor;

        public NumericThemeBuilder format(ClockNumericFormat clockNumericFormat) {
            this.clockNumericFormat = clockNumericFormat;
            return this;
        }

        public NumericThemeBuilder setNumbersColor(int numericNumbersColor) {
            this.numericNumbersColor = numericNumbersColor;
            return this;
        }

        public NumericTheme build() {
            return new NumericTheme(this);
        }
    }
}
