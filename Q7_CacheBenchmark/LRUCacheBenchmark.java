package Q7_CacheBenchmark;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheBenchmark<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCacheBenchmark(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public synchronized V getCache(K key) {
        return get(key);
    }

    public synchronized void putCache(K key, V value) {
        put(key, value);
    }
}