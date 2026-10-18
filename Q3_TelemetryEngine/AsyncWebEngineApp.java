package Q3_TelemetryEngine;

public class AsyncWebEngineApp {
    public static void main(String[] args) {
        System.out.println("Master JVM Entry Thread Name: " + Thread.currentThread().getName());

        TelemetryThread telemetryWorker = new TelemetryThread();
        telemetryWorker.setName("Telemetry-Worker");

        Thread logWorker = new Thread(new LogProcessorTask(), "Log-Worker");

        System.out.println("Starting background telemetry worker threads...");
        telemetryWorker.start();
        logWorker.start();

        System.out.println("Active Thread State -> Telemetry Worker: " + telemetryWorker.getState());
        System.out.println("Active Thread State -> Log Worker: " + logWorker.getState());

        try {
            telemetryWorker.join();
            logWorker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Master JVM Thread Clean-up complete.");
    }
}