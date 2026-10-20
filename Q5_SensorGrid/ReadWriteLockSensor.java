package Q5_SensorGrid;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockSensor {
    private int sensorId;
    private double temperature;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public ReadWriteLockSensor(int sensorId, double initialTemp) {
        this.sensorId = sensorId;
        this.temperature = initialTemp;
    }

    public double readTemperature() {
        rwLock.readLock().lock();
        try {
            return temperature;
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public void calibrateTemperature(double newTemp) {
        rwLock.writeLock().lock();
        try {
            System.out.println("<<< WRITE LOCK >>> Sensor #" + sensorId + " Calibrated to: " + newTemp + "°C");
            this.temperature = newTemp;
        } finally {
            rwLock.writeLock().unlock();
        }
    }
}