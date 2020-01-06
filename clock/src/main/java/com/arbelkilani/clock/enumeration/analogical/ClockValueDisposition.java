package com.arbelkilani.clock.enumeration.analogical;

public enum ClockValueDisposition {

    regular(-1), alternate(0);

    ClockValueDisposition(int i) {
        this.id = i;
    }

    private int id;

    public int getId() {
        return id;
    }
}
