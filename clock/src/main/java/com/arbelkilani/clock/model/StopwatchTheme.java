package com.arbelkilani.clock.model;

public class StopwatchTheme {

    private int stopwatchNumbersColor;
    private int stopwatchTypeFace;

    public int getStopwatchNumbersColor() {
        return stopwatchNumbersColor;
    }

    public int getStopwatchTypeFace() {
        return stopwatchTypeFace;
    }

    private StopwatchTheme(StopwatchThemeBuilder numericThemeBuilder) {
        this.stopwatchNumbersColor = numericThemeBuilder.stopwatchNumbersColor;
        this.stopwatchTypeFace = numericThemeBuilder.stopwatchTypeFace;
    }

    public static class StopwatchThemeBuilder {

        private int stopwatchNumbersColor;
        private int stopwatchTypeFace;

        public StopwatchThemeBuilder setColor(int stopwatchNumbersColor) {
            this.stopwatchNumbersColor = stopwatchNumbersColor;
            return this;
        }

        public StopwatchThemeBuilder setFont(int stopwatchTypeFace) {
            this.stopwatchTypeFace = stopwatchTypeFace;
            return this;
        }


        public StopwatchTheme build() {
            return new StopwatchTheme(this);
        }
    }
}
