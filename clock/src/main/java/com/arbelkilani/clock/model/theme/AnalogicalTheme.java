package com.arbelkilani.clock.model.theme;

import com.arbelkilani.clock.enumeration.ClockType;
import com.arbelkilani.clock.enumeration.analogical.DegreeType;
import com.arbelkilani.clock.enumeration.analogical.DegreesStep;
import com.arbelkilani.clock.enumeration.analogical.ValueDisposition;
import com.arbelkilani.clock.enumeration.analogical.ValueStep;
import com.arbelkilani.clock.enumeration.analogical.ValueType;

public class AnalogicalTheme {

    private ClockType clockType;

    private int clockBackground;

    private boolean showCenter;
    private int centerInnerColor;
    private int centerOuterColor;

    private boolean showBorder;
    private int borderColor;

    private boolean showSecondsNeedle;
    private int needleHoursColor;
    private int needleMinutesColor;
    private int needleSecondsColor;

    private boolean showProgress;
    private int progressColor;
    private boolean showMinutesProgress;
    private int minutesProgressColor;
    private float minutesProgressFactor;
    private boolean showSecondsProgress;
    private int secondsProgressColor;
    private float secondsProgressFactor;

    private boolean showDegrees;
    private int degreesColor;
    private DegreeType degreesType;
    private DegreesStep degreesStep;

    private int valuesFont;
    private int valuesColor;
    private boolean showHoursValues;
    private boolean showMinutesValues;
    private float minutesValuesFactor;
    private ValueStep valueStep;
    private ValueType valueType;
    private ValueDisposition valueDisposition;

    public ClockType getClockType() {
        return clockType;
    }

    public int getClockBackground() {
        return clockBackground;
    }

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

    public boolean isShowSecondsNeedle() {
        return showSecondsNeedle;
    }

    public int getNeedleHoursColor() {
        return needleHoursColor;
    }

    public int getNeedleMinutesColor() {
        return needleMinutesColor;
    }

    public int getNeedleSecondsColor() {
        return needleSecondsColor;
    }

    public boolean isShowProgress() {
        return showProgress;
    }

    public int getProgressColor() {
        return progressColor;
    }

    public boolean isShowMinutesProgress() {
        return showMinutesProgress;
    }

    public int getMinutesProgressColor() {
        return minutesProgressColor;
    }

    public float getMinutesProgressFactor() {
        return minutesProgressFactor;
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

    public boolean isShowDegrees() {
        return showDegrees;
    }

    public DegreeType getDegreesType() {
        return degreesType;
    }

    public DegreesStep getDegreesStep() {
        return degreesStep;
    }

    public int getDegreesColor() {
        return degreesColor;
    }

    public int getValuesFont() {
        return valuesFont;
    }

    public int getValuesColor() {
        return valuesColor;
    }

    public boolean isShowHoursValues() {
        return showHoursValues;
    }

    public boolean isShowMinutesValues() {
        return showMinutesValues;
    }

    public float getMinutesValuesFactor() {
        return minutesValuesFactor;
    }

    public ValueStep getValueStep() {
        return valueStep;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public ValueDisposition getValueDisposition() {
        return valueDisposition;
    }

    private AnalogicalTheme(AnalogicalThemeBuilder analogicalThemeBuilder) {

        this.clockType = analogicalThemeBuilder.clockType;

        this.clockBackground = analogicalThemeBuilder.clockBackground;

        this.showCenter = analogicalThemeBuilder.showCenter;
        this.centerInnerColor = analogicalThemeBuilder.centerInnerColor;
        this.centerOuterColor = analogicalThemeBuilder.centerOuterColor;

        this.showBorder = analogicalThemeBuilder.showBorder;
        this.borderColor = analogicalThemeBuilder.borderColor;

        this.showSecondsNeedle = analogicalThemeBuilder.showSecondsNeedle;
        this.needleHoursColor = analogicalThemeBuilder.needleHoursColor;
        this.needleMinutesColor = analogicalThemeBuilder.needleMinutesColor;
        this.needleSecondsColor = analogicalThemeBuilder.needleSecondsColor;

        this.showProgress = analogicalThemeBuilder.showProgress;
        this.progressColor = analogicalThemeBuilder.progressColor;
        this.showMinutesProgress = analogicalThemeBuilder.showMinutesProgress;
        this.minutesProgressColor = analogicalThemeBuilder.minutesProgressColor;
        this.minutesProgressFactor = analogicalThemeBuilder.minutesProgressFactor;
        this.showSecondsProgress = analogicalThemeBuilder.showSecondsProgress;
        this.secondsProgressColor = analogicalThemeBuilder.secondsProgressColor;
        this.secondsProgressFactor = analogicalThemeBuilder.secondsProgressFactor;

        this.showDegrees = analogicalThemeBuilder.showDegrees;
        this.degreesColor = analogicalThemeBuilder.degreesColor;
        this.degreesType = analogicalThemeBuilder.degreesType;
        this.degreesStep = analogicalThemeBuilder.degreesStep;

        this.valuesFont = analogicalThemeBuilder.valuesFont;
        this.valuesColor = analogicalThemeBuilder.valuesColor;
        this.showHoursValues = analogicalThemeBuilder.showHoursValues;
        this.showMinutesValues = analogicalThemeBuilder.showMinutesValues;
        this.minutesValuesFactor = analogicalThemeBuilder.minutesValuesFactor;
        this.valueStep = analogicalThemeBuilder.valueStep;
        this.valueType = analogicalThemeBuilder.valueType;
        this.valueDisposition = analogicalThemeBuilder.valueDisposition;
    }

    public static class AnalogicalThemeBuilder {

        private ClockType clockType;

        private int clockBackground;

        private boolean showCenter;
        private int centerInnerColor;
        private int centerOuterColor;

        private boolean showBorder;
        private int borderColor;

        private boolean showSecondsNeedle;
        private int needleHoursColor;
        private int needleMinutesColor;
        private int needleSecondsColor;

        private boolean showProgress;
        private int progressColor;
        private boolean showMinutesProgress;
        private int minutesProgressColor;
        private float minutesProgressFactor;
        private boolean showSecondsProgress;
        private int secondsProgressColor;
        private float secondsProgressFactor;

        private boolean showDegrees;
        private int degreesColor;
        private DegreeType degreesType;
        private DegreesStep degreesStep;

        private int valuesFont;
        private int valuesColor;
        private boolean showHoursValues;
        private boolean showMinutesValues;
        private float minutesValuesFactor;
        private ValueStep valueStep;
        private ValueType valueType;
        private ValueDisposition valueDisposition;

        public AnalogicalThemeBuilder setClockType(ClockType clockType) {
            this.clockType = clockType;
            return this;
        }

        public AnalogicalThemeBuilder setClockBackground(int clockBackground) {
            this.clockBackground = clockBackground;
            return this;
        }

        public AnalogicalThemeBuilder setShowCenter(boolean showCenter) {
            this.showCenter = showCenter;
            return this;
        }

        public AnalogicalThemeBuilder setCenterInnerColor(int centerInnerColor) {
            this.centerInnerColor = centerInnerColor;
            return this;
        }

        public AnalogicalThemeBuilder setCenterOuterColor(int centerOuterColor) {
            this.centerOuterColor = centerOuterColor;
            return this;
        }

        public AnalogicalThemeBuilder setShowBorder(boolean showBorder) {
            this.showBorder = showBorder;
            return this;
        }

        public AnalogicalThemeBuilder setBorderColor(int borderColor) {
            this.borderColor = borderColor;
            return this;
        }

        public AnalogicalThemeBuilder setShowSecondsNeedle(boolean showSecondsNeedle) {
            this.showSecondsNeedle = showSecondsNeedle;
            return this;
        }

        public AnalogicalThemeBuilder setNeedleHoursColor(int needleHoursColor) {
            this.needleHoursColor = needleHoursColor;
            return this;
        }

        public AnalogicalThemeBuilder setNeedleMinutesColor(int needleMinutesColor) {
            this.needleMinutesColor = needleMinutesColor;
            return this;
        }

        public AnalogicalThemeBuilder setNeedleSecondsColor(int needleSecondsColor) {
            this.needleSecondsColor = needleSecondsColor;
            return this;
        }

        public AnalogicalThemeBuilder setShowProgress(boolean showProgress) {
            this.showProgress = showProgress;
            return this;
        }

        public AnalogicalThemeBuilder setProgressColor(int progressColor) {
            this.progressColor = progressColor;
            return this;
        }

        public AnalogicalThemeBuilder setShowMinutesProgress(boolean showMinutesProgress) {
            this.showMinutesProgress = showMinutesProgress;
            return this;
        }

        public AnalogicalThemeBuilder setMinutesProgressColor(int minutesProgressColor) {
            this.minutesProgressColor = minutesProgressColor;
            return this;
        }

        public AnalogicalThemeBuilder setMinutesProgressFactor(float minutesProgressFactor) {
            this.minutesProgressFactor = minutesProgressFactor;
            return this;
        }

        public AnalogicalThemeBuilder setShowSecondsProgress(boolean showSecondsProgress) {
            this.showSecondsProgress = showSecondsProgress;
            return this;
        }

        public AnalogicalThemeBuilder setSecondsProgressColor(int secondsProgressColor) {
            this.secondsProgressColor = secondsProgressColor;
            return this;
        }

        public AnalogicalThemeBuilder setSecondsProgressFactor(float secondsProgressFactor) {
            this.secondsProgressFactor = secondsProgressFactor;
            return this;
        }

        public AnalogicalThemeBuilder setShowDegrees(boolean showDegrees) {
            this.showDegrees = showDegrees;
            return this;
        }

        public AnalogicalThemeBuilder setClockDegreesType(DegreeType degreesType) {
            this.degreesType = degreesType;
            return this;
        }

        public AnalogicalThemeBuilder setDegreesStep(DegreesStep degreesStep) {
            this.degreesStep = degreesStep;
            return this;
        }

        public AnalogicalThemeBuilder setDegreesColor(int degreesColor) {
            this.degreesColor = degreesColor;
            return this;
        }

        public AnalogicalThemeBuilder setDegreesType(DegreeType degreesType) {
            this.degreesType = degreesType;
            return this;
        }

        public AnalogicalThemeBuilder setValuesFont(int valuesFont) {
            this.valuesFont = valuesFont;
            return this;
        }

        public AnalogicalThemeBuilder setValuesColor(int valuesColor) {
            this.valuesColor = valuesColor;
            return this;
        }

        public AnalogicalThemeBuilder setShowHoursValues(boolean showHoursValues) {
            this.showHoursValues = showHoursValues;
            return this;
        }

        public AnalogicalThemeBuilder setShowMinutesValues(boolean showMinutesValues) {
            this.showMinutesValues = showMinutesValues;
            return this;
        }

        public AnalogicalThemeBuilder setMinutesValuesFactor(float minutesValuesFactor) {
            this.minutesValuesFactor = minutesValuesFactor;
            return this;
        }

        public AnalogicalThemeBuilder setValueStep(ValueStep valueStep) {
            this.valueStep = valueStep;
            return this;
        }

        public AnalogicalThemeBuilder setValueType(ValueType valueType) {
            this.valueType = valueType;
            return this;
        }

        public AnalogicalThemeBuilder setValueDisposition(ValueDisposition valueDisposition) {
            this.valueDisposition = valueDisposition;
            return this;
        }

        public AnalogicalTheme build() {
            return new AnalogicalTheme(this);
        }
    }
}
