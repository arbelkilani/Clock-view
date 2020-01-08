package com.arbelkilani.clock.enumeration.analogical;

public enum ValueStep {

    quarter(90), full(30);

    ValueStep(int i) {
        this.id = i;
    }

    private int id;

    public int getId() {
        return id;
    }

    public static ValueStep fromId(int id) {
        for (ValueStep valueStep : values()) {
            if (valueStep.id == id) return valueStep;
        }
        throw new IllegalArgumentException();
    }
}
