package Q6_CatalogBenchmark;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryCatalog {
    private Map<String, Double> syncMap = Collections.synchronizedMap(new HashMap<>());
    private ConcurrentHashMap<String, Double> concurrentMap = new ConcurrentHashMap<>();

    public void benchmarkSyncMap(int operations) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < operations; i++) {
            syncMap.put("SKU_" + i, (double) i);
            syncMap.get("SKU_" + i);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("[Synchronized HashMap] Time Taken for " + operations + " ops: " + duration + " ms");
    }

    public void benchmarkConcurrentMap(int operations) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < operations; i++) {
            concurrentMap.put("SKU_" + i, (double) i);
            concurrentMap.get("SKU_" + i);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("[ConcurrentHashMap] Time Taken for " + operations + " ops: " + duration + " ms");
    }
}
