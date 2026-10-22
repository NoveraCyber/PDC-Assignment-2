package Q7_CacheBenchmark;

public class CacheBenchmarkApp {
    public static void main(String[] args) {
        int cacheCapacity = 3;
        LRUCacheBenchmark<Integer, String> cache = new LRUCacheBenchmark<>(cacheCapacity);

        System.out.println("--- Starting Synchronized LRU Cache Eviction Benchmark ---");
        System.out.println("Inserting initial entries (Capacity = 3)...");
        cache.putCache(1, "Session_Token_A");
        cache.putCache(2, "Session_Token_B");
        cache.putCache(3, "Session_Token_C");

        System.out.println("Accessing Entry 1 to update LRU order...");
        cache.getCache(1); // Access key 1, making key 2 the eldest

        System.out.println("Inserting Entry 4 (Triggers eviction of eldest entry)...");
        cache.putCache(4, "Session_Token_D");

        System.out.println("Cache Contents Post-Eviction Test:");
        System.out.println("Key 1 present: " + (cache.getCache(1) != null));
        System.out.println("Key 2 present (Expected false due to eviction): " + (cache.getCache(2) != null));
        System.out.println("Key 3 present: " + (cache.getCache(3) != null));
        System.out.println("Key 4 present: " + (cache.getCache(4) != null));

        System.out.println("LRU Cache Benchmark Execution Completed Successfully.");
    }
}