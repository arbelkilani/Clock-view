package com.arbelkilani.clock.enumeration.analogical;

public enum DegreeType {

    line(0), circle(1), square(2);

    DegreeType(int i) {
        this.id = i;
    }

    private int id;

    public int getId() {
        return id;
    }

    public static DegreeType fromId(int id) {
        for (DegreeType clockDegreeType : values()) {
            if (clockDegreeType.id == id) return clockDegreeType;
        }
        throw new IllegalArgumentException();
    }
}
