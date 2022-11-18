package sample.liskov.demo2;

public class TransportationDeviceWrong {

    static class TransportationDevice {
        protected String name;
        protected double speed;
        protected Engine engine;

        void startEngine() {
            engine.start();
        }
    }

    static class Car extends TransportationDevice {
        @Override
        public void startEngine() {
            System.out.println("Car Started");
        }
    }

    static class Bicycle extends TransportationDevice {
        @Override
        void startEngine() {
            System.out.println("Error bicycle has no engine");
        }
    }

    private static class Engine {
        private void start() {
            System.out.println("Engine started");
        }
    }
}
