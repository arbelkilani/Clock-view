package com.arbelkilani.clock.enumeration;

public enum ClockDegreeStep {

    quarter(90), full(6), twelve(30);

    ClockDegreeStep(int i) {
        this.id = i;
    }

    private int id;

    public int getId() {
        return id;
    }
}
