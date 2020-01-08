package com.arbelkilani.clock.enumeration.numeric;

public enum NumericFormat {

    hour_12(0), hour_24(1);

    NumericFormat(int i) {
        this.id = i;
    }

    private int id;

    public int getId() {
        return id;
    }

    public static NumericFormat fromId(int id) {
        for (NumericFormat numericFormat : values()) {
            if (numericFormat.id == id) return numericFormat;
        }
        throw new IllegalArgumentException();
    }
}
