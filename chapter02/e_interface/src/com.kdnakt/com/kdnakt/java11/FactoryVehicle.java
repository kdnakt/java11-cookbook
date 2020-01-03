package com.kdnakt.java11;

public class FactoryVehicle {
    public static Car buildCar(int passengersCount, int weightPounds, int horsePower) {
        return new CarImpl(passengersCount, weightPounds, horsePower);
    }

    public static Truck buildTruck(int payloadPounds, int weightPounds, int horsePower) {
        return new TruckImpl(payloadPounds, weightPounds, horsePower);
    }

    public static Vehicle buildCrewCab(int passengersCount, int payload, int weightPounds, int horsePower) {
        return new CrewCabImpl(passengersCount, payload, weightPounds, horsePower);
    }

    private static class CarImpl extends VehicleImpl implements Car {
        private int passengersCount;

        private CarImpl(int passengersCount, int weightPounds, int horsePower) {
            super(weightPounds + passengersCount * 250, horsePower);
            this.passengersCount = passengersCount;
        }

        public int getPassengersCount() {
            return this.passengersCount;
        }
    }

    private static class TruckImpl extends VehicleImpl implements Truck {
        private int payloadPounds;

        private TruckImpl(int payloadPounds, int weightPounds, int horsePower) {
            super(weightPounds + payloadPounds, horsePower);
            this.payloadPounds = payloadPounds;
        }

        public int getPayloadPounds() {
            return payloadPounds;
        }
    }

    private static class CrewCabImpl extends VehicleImpl implements Car, Truck {
        private int payloadPounds;
        private int passengersCount;

        private CrewCabImpl(int passengersCount, int payloadPounds, int weightPounds, int horsePower) {
            super(weightPounds + payloadPounds + passengersCount * 250, horsePower);
            this.payloadPounds = payloadPounds;
            this. passengersCount = passengersCount;
        }

        public int getPayloadPounds() {
            return payloadPounds;
        }

        public int getPassengersCount() {
            return this.passengersCount;
        }
    }

    private static abstract class VehicleImpl implements Vehicle {
        private SpeedModel speedModel;
        private int weightPounds, horsePower;

        private VehicleImpl(int weightPounds, int horsePower) {
            this.weightPounds = weightPounds;
            this.horsePower = horsePower;
        }

        public void setSpeedModel(SpeedModel speedModel) {
            this.speedModel = speedModel;
        }

        public double getSpeedMph(double timeSec) {
            return this.speedModel.getSpeedMph(timeSec, weightPounds, horsePower);
        }
    }
}