package Q5_SensorGrid;

public class SensorGridMonitorApp {
    public static void main(String[] args) throws InterruptedException {
        SensorNode node = new SensorNode(101, 24.5);
        ReadWriteLockSensor rwSensor = new ReadWriteLockSensor(202, 30.0);

        System.out.println("--- Starting Synchronized Sensor Updates ---");
        Thread t1 = new Thread(() -> node.updateReading(26.8), "Updater-Thread-1");
        Thread t2 = new Thread(() -> node.updateReading(28.2), "Updater-Thread-2");
        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("--- Starting ReadWriteLock Telemetry ---");
        Runnable reader = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("[READ LOCK] " + Thread.currentThread().getName() + " Sensor Temp: " + rwSensor.readTemperature() + "°C");
                try { Thread.sleep(200); } catch (InterruptedException e) {}
            }
        };

        Thread r1 = new Thread(reader, "Reader-A");
        Thread r2 = new Thread(reader, "Reader-B");
        Thread w1 = new Thread(() -> rwSensor.calibrateTemperature(35.4), "Writer-Calibrator");

        r1.start(); r2.start(); w1.start();
        r1.join(); r2.join(); w1.join();

        System.out.println("IoT Sensor Monitor Execution Complete.");
    }
}
