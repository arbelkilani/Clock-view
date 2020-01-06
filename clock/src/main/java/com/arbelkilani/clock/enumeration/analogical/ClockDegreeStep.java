package com.arbelkilani.clock.enumeration.analogical;

public enum ClockDegreeStep {

    quarter(90), full(6), twelve(30);

    ClockDegreeStep(int i) {
        this.id = i;
    }

    private int id;

    public int getId() {
        return id;
    }

    public static ClockDegreeStep fromId(int id) {
        for (ClockDegreeStep clockDegreeStep : values()) {
            if (clockDegreeStep.id == id) return clockDegreeStep;
        }
        throw new IllegalArgumentException();
    }
}
