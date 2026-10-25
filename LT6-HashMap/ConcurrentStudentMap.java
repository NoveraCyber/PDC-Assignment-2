import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentStudentMap {
    public static void main(String[] args) {
        // 1. Create ConcurrentHashMap
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        int threadCount = 5;
        int recordsPerThread = 1000;
        // 2. Create ExecutorService with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        long startTime = System.currentTimeMillis();
        // 3. Make each thread insert 1,000 unique records
        for (int t = 0; t < threadCount; t++) {
            final int threadId = t;
            executor.submit(() -> {
                for (int i = 0; i < recordsPerThread; i++) {
                    String key = "Worker_" + threadId + "_SKU_" + i;
                    concurrentMap.put(key, 60 + (i % 40));
                    // 4. Retrieve values associated with inserted keys
                    concurrentMap.get(key);
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        // 5. Measure total execution time in milliseconds
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        int expectedEntries = threadCount * recordsPerThread;
        int actualEntries = concurrentMap.size();
        // 6. Display details
        System.out.println("--- ConcurrentHashMap Execution Summary ---");
        System.out.println("Number of Threads: " + threadCount);
        System.out.println("Expected Entries:  " + expectedEntries);
        System.out.println("Actual Entries:    " + actualEntries);
        System.out.println("Execution Time:    " + executionTime + " ms");
    }
}