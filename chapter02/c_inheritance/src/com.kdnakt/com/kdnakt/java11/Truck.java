package com.kdnakt.java11;

public class Truck extends Vehicle {
    private int payload, weightPounds;

    public Truck(int payloadPounds, int weightPounds, int horsePower) {
        super(weightPounds, horsePower);
        this.payload = payloadPounds;
        this.weightPounds = weightPounds;
    }

    public int getPayload() {
        return this.payload;
    }

    public int getMaxWeightPounds() {
        return this.weightPounds + this.payload;
    }
}