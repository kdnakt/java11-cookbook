package com.kdnakt.java11;

public class Vehicle {
    private int weightPounds;
    private Engine engine;

    public Vehicle(int weightPounds, Engine engine) {
        this.weightPounds = weightPounds;
        this.engine = engine;
    }

    public double getSpeedMph(double timeSec) {
        return this.engine.getSpeedMph(timeSec, weightPounds);
    }
}