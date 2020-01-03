package com.kdnakt.java11;

import java.util.Properties;

public class FactorySpeedModel {
    public static SpeedModel generateSpeedModel(Properties drivingConditions){
        String road = drivingConditions.getProperty("roadCondition", "Dry");
        if (road.equals("Dry")) {
            return new SpeedModelDry();
        } else {
            return new SpeedModelWet();
        }
    }

    private static class SpeedModelWet implements SpeedModel {
        public double getSpeedMph(double timeSec, int weightPounds, int horsePower) {
            double v = 2.0 * horsePower * 746 * timeSec * 32.17 / weightPounds;
            return Math.round(Math.sqrt(v) * 0.68) - 5;
        }
    }

    private static class SpeedModelDry implements SpeedModel {
        public double getSpeedMph(double timeSec, int weightPounds, int horsePower) {
            double v = 2.0 * horsePower * 746 * timeSec * 32.17 / weightPounds;
            return Math.round(Math.sqrt(v) * 0.68) - 2;
        }
    }
}