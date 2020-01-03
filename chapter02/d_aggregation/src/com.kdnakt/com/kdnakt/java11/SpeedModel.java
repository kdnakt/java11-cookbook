package com.kdnakt.java11;

import java.util.Properties;

public class SpeedModel {
    private Properties drivingConditions;

    public SpeedModel(Properties drivingConditions) {
        this.drivingConditions = drivingConditions;
    }

    public double getSpeedMph(double timeSec, int weightPounds, int horsePower) {
        String road = drivingConditions.getProperty("roadCondition", "Dry");
        String tire = drivingConditions.getProperty("tireCondition", "New");
        double v = 2.0 * horsePower * 746 * timeSec * 32.17 / weightPounds;
        return Math.round(Math.sqrt(v) * 0.68) - (road.equals("Dry") ? 2 : 5) - (tire.equals("New") ? 0 : 5);
    }
}