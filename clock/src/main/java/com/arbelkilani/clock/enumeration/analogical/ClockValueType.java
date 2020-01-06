package com.arbelkilani.clock.enumeration.analogical;

public enum ClockValueType {

    none(-1), roman(0), arabic(1);

    ClockValueType(int i) {
        this.id = i;
    }

    private int id;

    public int getId() {
        return id;
    }
}
