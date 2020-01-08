package com.arbelkilani.clock.enumeration.analogical;

public enum DegreesStep {

    quarter(90), full(6), twelve(30);

    DegreesStep(int i) {
        this.id = i;
    }

    private int id;

    public int getId() {
        return id;
    }

    public static DegreesStep fromId(int id) {
        for (DegreesStep degreesStep : values()) {
            if (degreesStep.id == id) return degreesStep;
        }
        throw new IllegalArgumentException();
    }
}
