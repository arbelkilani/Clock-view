package com.arbelkilani.clock.enumeration.analogical;

public enum ClockDegreeType {

    line(0), circle(1), square(2);

    ClockDegreeType(int i) {
        this.id = i;
    }

    private int id;

    public int getId() {
        return id;
    }

    public static ClockDegreeType fromId(int id) {
        for (ClockDegreeType clockDegreeType : values()) {
            if (clockDegreeType.id == id) return clockDegreeType;
        }
        throw new IllegalArgumentException();
    }
}
