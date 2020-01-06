package com.arbelkilani.clock.enumeration.analogical;

public enum ClockValueStep {

    quarter(90), full(30);

    ClockValueStep(int i) {
        this.id = i;
    }

    private int id;

    public int getId() {
        return id;
    }
}
