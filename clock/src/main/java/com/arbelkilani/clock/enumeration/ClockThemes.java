package com.arbelkilani.clock.enumeration;

public enum ClockThemes {

    theme0(-1), theme1(0), theme2(1), theme3(2), theme4(3);

    ClockThemes(int i) {
        this.id = i;
    }

    private int id;

    public int getId() {
        return id;
    }
}
