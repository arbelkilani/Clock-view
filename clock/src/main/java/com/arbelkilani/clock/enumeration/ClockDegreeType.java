package com.arbelkilani.clock.enumeration;

public enum ClockDegreeType {

    line(0), circle(1), square(2);

    ClockDegreeType(int i) {
        this.id = i;
    }

    private int id;

    public int getId() {
        return id;
    }
}
