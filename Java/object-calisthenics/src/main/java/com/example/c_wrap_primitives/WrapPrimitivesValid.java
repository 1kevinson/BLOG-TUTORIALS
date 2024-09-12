package com.example.c_wrap_primitives;

public class WrapPrimitivesValid {
    
    private Distance meter = new Distance(1, "meter");
    private Distance kilometer = meter.toKilometer();

}

class Distance {

    private int value;
    private String unit;

    Distance(int value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Distance toKilometer() {
        return new Distance(this.value * 1000, "kilometer");
    }

}