package com.arbelkilani.clock.enumeration.analogical;

public enum ValueType {

    none(-1), roman(0), arabic(1);

    ValueType(int i) {
        this.id = i;
    }

    private int id;

    public int getId() {
        return id;
    }

    public static ValueType fromId(int id) {
        for (ValueType valueType : values()) {
            if (valueType.id == id) return valueType;
        }
        throw new IllegalArgumentException();
    }
}
