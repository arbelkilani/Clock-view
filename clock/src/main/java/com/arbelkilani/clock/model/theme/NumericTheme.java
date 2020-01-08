package com.arbelkilani.clock.model.theme;

import com.arbelkilani.clock.enumeration.BorderStyle;
import com.arbelkilani.clock.enumeration.ClockType;
import com.arbelkilani.clock.enumeration.numeric.NumericFormat;

public class NumericTheme {

    private ClockType clockType;

    private int clockBackground;

    private int valuesFont;
    private int valuesColor;

    private boolean showBorder;
    private int borderColor;
    private BorderStyle borderStyle;
    private int borderRadiusRx;
    private int borderRadiusRy;

    private NumericFormat numericFormat;

    private boolean numericShowSeconds;

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

    public boolean isShowBorder() {
        return showBorder;
    }

    public int getBorderColor() {
        return borderColor;
    }

    public BorderStyle getBorderStyle() {
        return borderStyle;
    }

    public int getBorderRadiusRx() {
        return borderRadiusRx;
    }

    public int getBorderRadiusRy() {
        return borderRadiusRy;
    }

    public NumericFormat getNumericFormat() {
        return numericFormat;
    }

    public boolean isNumericShowSeconds() {
        return numericShowSeconds;
    }

    private NumericTheme(NumericThemeBuilder numericThemeBuilder) {

        this.clockType = numericThemeBuilder.clockType;

        this.clockBackground = numericThemeBuilder.clockBackground;

        this.valuesFont = numericThemeBuilder.valuesFont;
        this.valuesColor = numericThemeBuilder.valuesColor;

        this.showBorder = numericThemeBuilder.showBorder;
        this.borderColor = numericThemeBuilder.borderColor;
        this.borderStyle = numericThemeBuilder.borderStyle;
        this.borderRadiusRx = numericThemeBuilder.borderRadiusRx;
        this.borderRadiusRy = numericThemeBuilder.borderRadiusRy;

        this.numericFormat = numericThemeBuilder.numericFormat;

        this.numericShowSeconds = numericThemeBuilder.numericShowSeconds;
    }

    public static class NumericThemeBuilder {

        private ClockType clockType;

        private int clockBackground;

        private int valuesFont;
        private int valuesColor;

        private boolean showBorder;
        private int borderColor;
        private BorderStyle borderStyle;
        private int borderRadiusRx;
        private int borderRadiusRy;

        private NumericFormat numericFormat;

        private boolean numericShowSeconds;

        public NumericThemeBuilder setClockType(ClockType clockType) {
            this.clockType = clockType;
            return this;
        }

        public NumericThemeBuilder setClockBackground(int clockBackground) {
            this.clockBackground = clockBackground;
            return this;
        }

        public NumericThemeBuilder setValuesFont(int valuesFont) {
            this.valuesFont = valuesFont;
            return this;
        }

        public NumericThemeBuilder setValuesColor(int valuesColor) {
            this.valuesColor = valuesColor;
            return this;
        }

        public NumericThemeBuilder setShowBorder(boolean showBorder) {
            this.showBorder = showBorder;
            return this;
        }

        public NumericThemeBuilder setBorderColor(int borderColor) {
            this.borderColor = borderColor;
            return this;
        }

        public NumericThemeBuilder setBorderStyle(BorderStyle borderStyle) {
            this.borderStyle = borderStyle;
            return this;
        }

        public NumericThemeBuilder setBorderRadius(int borderRadiusRx, int borderRadiusRy) {
            this.borderRadiusRx = borderRadiusRx;
            this.borderRadiusRy = borderRadiusRy;
            return this;
        }

        public NumericThemeBuilder setNumericFormat(NumericFormat numericFormat) {
            this.numericFormat = numericFormat;
            return this;
        }

        public NumericThemeBuilder setNumericShowSeconds(boolean numericShowSeconds) {
            this.numericShowSeconds = numericShowSeconds;
            return this;
        }

        public NumericTheme build() {
            return new NumericTheme(this);
        }
    }
}
