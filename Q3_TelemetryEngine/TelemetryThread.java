package Q3_TelemetryEngine;

public class TelemetryThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] CPU & Memory Health Update " + i + ": Metrics Optimal");
            try { Thread.sleep(800); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }
}
