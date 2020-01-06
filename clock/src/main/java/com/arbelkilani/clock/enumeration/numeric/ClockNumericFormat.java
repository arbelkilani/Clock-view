package com.arbelkilani.clock.enumeration.numeric;

public enum ClockNumericFormat {

    hour_12(0), hour_24(1);

    ClockNumericFormat(int i) {
        this.id = i;
    }

    private int id;

    public int getId() {
        return id;
    }

    public static ClockNumericFormat fromId(int id) {
        for (ClockNumericFormat clockNumericFormat : values()) {
            if (clockNumericFormat.id == id) return clockNumericFormat;
        }
        throw new IllegalArgumentException();
    }
}
