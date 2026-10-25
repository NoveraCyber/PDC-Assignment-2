import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedStudentMap {
    public static void main(String[] args) {
        // 1. Convert HashMap into a synchronized map
        Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());

        // 2. Create ExecutorService with 3 threads
        int threadCount = 3;
        int recordsPerThread = 100;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        // 3. Make each thread insert 100 unique student records
        for (int t = 0; t < threadCount; t++) {
            final int threadId = t;
            executor.submit(() -> {
                for (int i = 0; i < recordsPerThread; i++) {
                    syncMap.put("T" + threadId + "_Student_" + i, 50 + (i % 50));
                }
            });
        }
        // 4. Shutdown and await termination to guarantee all worker threads finish
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        // 5. Display expected vs actual entries
        int expectedEntries = threadCount * recordsPerThread;
        int actualEntries = syncMap.size();
        System.out.println("--- Synchronized Map Execution Summary ---");
        System.out.println("Threads Used:     " + threadCount);
        System.out.println("Expected Entries: " + expectedEntries);
        System.out.println("Actual Entries:   " + actualEntries);
        System.out.println("Validation State: " + (expectedEntries == actualEntries ? "PASSED (Thread-safe)" : "FAILED"));
    }
}