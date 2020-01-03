package com.kdnakt.java11;

public class Car extends Vehicle {
    private int passengersCount, weightPounds;

    public Car(int passengersCount, int weightPounds, int horsePower) {
        super(weightPounds, horsePower);
        this.passengersCount = passengersCount;
        this.weightPounds = weightPounds;
    }

    public int getPassengersCount() {
        return this.passengersCount;
    }

    public int getMaxWeightPounds() {
        return this.weightPounds + this.passengersCount * 250;
    }
}