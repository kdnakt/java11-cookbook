package com.kdnakt.java11;

public class Car extends Vehicle {
    private int passengersCount;

    public Car(int passengersCount, int weightPounds, int horsePower) {
        super(weightPounds, horsePower);
        this.passengersCount = passengersCount;
    }

    public int getPassengersCount() {
        return this.passengersCount;
    }

    public double getSpeedMph(double timeSec) {
        int weight = this.weightPounds + this.passengersCount * 250;
        double v = 2.0 * this.horsePower * 746 * timeSec * 32.17 / weight;
        return Math.round(Math.sqrt(v) * 0.68);
    }
}