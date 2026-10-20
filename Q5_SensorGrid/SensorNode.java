package Q5_SensorGrid;

public class SensorNode {
    private int sensorId;
    private double currentTemperature;

    public SensorNode(int sensorId, double currentTemperature) {
        this.sensorId = sensorId;
        this.currentTemperature = currentTemperature;
    }

    public synchronized void updateReading(double newTemp) {
        System.out.println("[Sensor Node #" + sensorId + "] Updating reading from " + currentTemperature + "°C to " + newTemp + "°C");
        this.currentTemperature = newTemp;
    }

    public synchronized double getCurrentTemperature() {
        return currentTemperature;
    }

    public int getSensorId() {
        return sensorId;
    }
}