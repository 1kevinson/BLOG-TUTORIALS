package sample.liskov.demo2;

public class TransportationDeviceCorrect {

    static class TransportationVehicle {
        protected String name;
        protected double speed;
    }

    static class VehicleWithoutEngine extends TransportationVehicle {
        void startMoving() {

        }
    }

    static class VehicleWithEngine extends TransportationVehicle {
        protected Engine engine;

        void startEngine() {engine.start();
        }
    }

    static class Car extends VehicleWithEngine {
        @Override
        public void startEngine() {
            System.out.println("Car Started");
        }
    }

    static class Bicycle extends VehicleWithoutEngine {
        @Override
        void startMoving() {
            System.out.println("Bicycle Moving");
        }
    }

    private static class Engine {
        private void start() {
            System.out.println("Engine started");
        }
    }
}
