package com.kdnakt.java11;

public class Vehicle {
    protected int weightPounds, horsePower;

    public Vehicle(int weightPounds, int horsePower) {
        this.weightPounds = weightPounds;
        this.horsePower = horsePower;
    }

    public double getSpeedMph(double timeSec) {
        double v = 2.0 * this.horsePower * 746 * timeSec * 32.17 / this.weightPounds;
        return Math.round(Math.sqrt(v) * 0.68);
    }

}